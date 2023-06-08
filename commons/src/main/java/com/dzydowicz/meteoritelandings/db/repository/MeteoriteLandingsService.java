package com.dzydowicz.meteoritelandings.db.repository;

import com.dzydowicz.meteoritelandings.exceptions.MeteoriteLandingNotFoundException;
import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingFilterTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingUpdateTO;

import java.util.List;
import java.util.stream.Collectors;

public class MeteoriteLandingsService implements IMeteoriteLandingsService {
    private final MeteoriteLandingsRepository repository;
    private Integer highestId;

    public MeteoriteLandingsService(MeteoriteLandingsRepository repository) {
        this.repository = repository;
    }

    public MeteoriteLandingTO findMeteoriteLanding(int meteoriteLandingId) throws MeteoriteLandingNotFoundException {
        return repository.findById(meteoriteLandingId)
                .orElseThrow(() -> new MeteoriteLandingNotFoundException("Cannot find meteorite landing with id: " + meteoriteLandingId));
    }

    public List<MeteoriteLandingTO> getFilteredMeteoriteLandings(MeteoriteLandingFilterTO meteoriteLandingFilterTO) {
        return repository.findMeteoriteLandingsByFilter(meteoriteLandingFilterTO);
    }

    public MeteoriteLandingTO updateMeteoriteLanding(int meteoriteLandingId, MeteoriteLandingUpdateTO meteoriteLandingUpdateTO) throws MeteoriteLandingNotFoundException {
        if (!repository.existsById(meteoriteLandingId)) {
            throw new MeteoriteLandingNotFoundException("Cannot find meteorite landing with id: " + meteoriteLandingId);
        }

        MeteoriteLandingTO meteoriteLandingTO = createMeteoriteLandingTO(meteoriteLandingId, meteoriteLandingUpdateTO);
        return repository.save(meteoriteLandingTO);
    }

    public List<MeteoriteLandingTO> createMultipleMeteoriteLandings(List<MeteoriteLandingCreationTO> meteoriteLandingCreationTOs) {
        List<MeteoriteLandingTO> meteoriteLandingTOs = meteoriteLandingCreationTOs.stream()
                .map(this::createMeteoriteLandingTO)
                .collect(Collectors.toList());
        return repository.insertAll(meteoriteLandingTOs);
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

    private MeteoriteLandingTO createMeteoriteLandingTO(MeteoriteLandingCreationTO meteoriteLandingCreationTO) {
        Integer actualHighestId = highestId != null ? highestId : repository.obtainHighestId();
        highestId = actualHighestId != null ? actualHighestId + 1 : 1;

        return createMeteoriteLandingTO(highestId, meteoriteLandingCreationTO);
    }

    private MeteoriteLandingTO createMeteoriteLandingTO(int meteoriteLandingId, MeteoriteLandingCreationTO meteoriteLandingCreationTO) {
        String geoLocation = String.format("(%f, %f)", meteoriteLandingCreationTO.getLatCoordination(), meteoriteLandingCreationTO.getLongCoordination());

        return MeteoriteLandingTO.builder()
                .id(meteoriteLandingId)
                .name(meteoriteLandingCreationTO.getName())
                .nameType(meteoriteLandingCreationTO.getNameType())
                .classification(meteoriteLandingCreationTO.getClassification())
                .mass(meteoriteLandingCreationTO.getMass())
                .fall(meteoriteLandingCreationTO.getFall())
                .year(meteoriteLandingCreationTO.getYear())
                .latCoordination(meteoriteLandingCreationTO.getLatCoordination())
                .longCoordination(meteoriteLandingCreationTO.getLongCoordination())
                .geoLocation(geoLocation)
                .build();
    }

    private MeteoriteLandingTO createMeteoriteLandingTO(int meteoriteLandingId, MeteoriteLandingUpdateTO meteoriteLandingUpdateTO) {
        String geoLocation = String.format("(%f, %f)", meteoriteLandingUpdateTO.getLatCoordination(), meteoriteLandingUpdateTO.getLongCoordination());

        return MeteoriteLandingTO.builder()
                .id(meteoriteLandingId)
                .name(meteoriteLandingUpdateTO.getName())
                .nameType(meteoriteLandingUpdateTO.getNameType())
                .classification(meteoriteLandingUpdateTO.getClassification())
                .mass(meteoriteLandingUpdateTO.getMass())
                .fall(meteoriteLandingUpdateTO.getFall())
                .year(meteoriteLandingUpdateTO.getYear())
                .latCoordination(meteoriteLandingUpdateTO.getLatCoordination())
                .longCoordination(meteoriteLandingUpdateTO.getLongCoordination())
                .geoLocation(geoLocation)
                .build();
    }
}
