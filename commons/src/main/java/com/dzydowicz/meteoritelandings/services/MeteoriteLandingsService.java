package com.dzydowicz.meteoritelandings.services;

import com.dzydowicz.meteoritelandings.db.repository.MeteoriteLandingsRepository;
import com.dzydowicz.meteoritelandings.exceptions.MeteoriteLandingNotFoundException;
import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingFilterTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeteoriteLandingsService {
    private final MeteoriteLandingsRepository repository;

    private Integer highestId;

    @Autowired
    public MeteoriteLandingsService(MeteoriteLandingsRepository repository) {
        this.repository = repository;
    }

    public MeteoriteLandingTO findMeteoriteLanding(int meteoriteLandingId) throws MeteoriteLandingNotFoundException {
        return repository.findById(meteoriteLandingId)
                .orElseThrow(() -> new MeteoriteLandingNotFoundException("Cannot find meteorite landing with id: " + meteoriteLandingId));
    }

    public List<MeteoriteLandingTO> getMultiMeteoriteLandings(MeteoriteLandingFilterTO meteoriteLandingFilterTO) {
        Query query = new Query();

        if (meteoriteLandingFilterTO.getIds() != null && !meteoriteLandingFilterTO.getIds().isEmpty()){
            query.addCriteria(Criteria.where("id").in(meteoriteLandingFilterTO.getIds()));
        }

        if (meteoriteLandingFilterTO.getNameType() != null) {
            query.addCriteria(Criteria.where("nametype").is(meteoriteLandingFilterTO.getNameType()));
        }

        if (meteoriteLandingFilterTO.getFall() != null) {
            query.addCriteria(Criteria.where("nametype").is(meteoriteLandingFilterTO.getFall()));
        }

        if (meteoriteLandingFilterTO.getMinMass() != null) {
            query.addCriteria(Criteria.where("nametype").gte(meteoriteLandingFilterTO.getMinMass()));
        }

        if (meteoriteLandingFilterTO.getMaxMass() != null) {
            query.addCriteria(Criteria.where("nametype").lte(meteoriteLandingFilterTO.getMaxMass()));
        }

        if (meteoriteLandingFilterTO.getMinYear() != null) {
            query.addCriteria(Criteria.where("nametype").gte(meteoriteLandingFilterTO.getMinYear()));
        }

        if (meteoriteLandingFilterTO.getMaxYear() != null) {
            query.addCriteria(Criteria.where("nametype").lte(meteoriteLandingFilterTO.getMaxYear()));
        }

        return repository.findAll(query);
    }

    public MeteoriteLandingTO updateMeteoriteLanding(int meteoriteLandingId, MeteoriteLandingCreationTO meteoriteLandingCreationTO) throws MeteoriteLandingNotFoundException {
        if (!repository.existsById(meteoriteLandingId)) {
            throw new MeteoriteLandingNotFoundException("Cannot find meteorite landing with id: " + meteoriteLandingId);
        }

        MeteoriteLandingTO meteoriteLandingTO = createMeteoriteLandingTO(meteoriteLandingId, meteoriteLandingCreationTO);
        return repository.save(meteoriteLandingTO);
    }

    public List<MeteoriteLandingTO> createMultipleMeteoriteLandings(List<MeteoriteLandingCreationTO> meteoriteLandingCreationTOs) {
        List<MeteoriteLandingTO> meteoriteLandingTOs = meteoriteLandingCreationTOs.stream()
                .map(this::createMeteoriteLandingTO)
                .collect(Collectors.toList());
        return repository.saveAll(meteoriteLandingTOs);
    }

    public MeteoriteLandingTO createMeteoriteLanding(MeteoriteLandingCreationTO meteoriteLandingCreationTO) {
        MeteoriteLandingTO meteoriteLandingTO = createMeteoriteLandingTO(meteoriteLandingCreationTO);
        return repository.save(meteoriteLandingTO);
    }

    public void removeMeteoriteLanding(int meteoriteLandingId) throws MeteoriteLandingNotFoundException {
        if (!repository.existsById(meteoriteLandingId)) {
            throw new MeteoriteLandingNotFoundException("Cannot find meteorite landing with id: " + meteoriteLandingId);
        }

        repository.deleteById(meteoriteLandingId);
    }

    private int findHighestId() {
        if (highestId == null) {
            PageRequest request = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "_id"));
            Page<MeteoriteLandingTO> pages = repository.findAll(request);

            MeteoriteLandingTO meteoriteLandingTO = pages.get().findFirst().get();
            highestId = meteoriteLandingTO.getId();
        }

        return highestId;
    }

    private MeteoriteLandingTO createMeteoriteLandingTO(MeteoriteLandingCreationTO meteoriteLandingCreationTO) {
        int id = findHighestId() + 1;
        return createMeteoriteLandingTO(id, meteoriteLandingCreationTO);
    }

    private MeteoriteLandingTO createMeteoriteLandingTO(int meteoriteLandingId, MeteoriteLandingCreationTO meteoriteLandingCreationTO) {
        String geoLocation = String.format("(%f, %f)", meteoriteLandingCreationTO.getLatCoordination(), meteoriteLandingCreationTO.getLongCoordination());

        return new MeteoriteLandingTO(meteoriteLandingId, meteoriteLandingCreationTO.getName(), meteoriteLandingCreationTO.getNameType(), meteoriteLandingCreationTO.getClassification(),
                meteoriteLandingCreationTO.getMass(), meteoriteLandingCreationTO.getFall(), meteoriteLandingCreationTO.getYear(),
                meteoriteLandingCreationTO.getLatCoordination(), meteoriteLandingCreationTO.getLongCoordination(), geoLocation);
    }
}
