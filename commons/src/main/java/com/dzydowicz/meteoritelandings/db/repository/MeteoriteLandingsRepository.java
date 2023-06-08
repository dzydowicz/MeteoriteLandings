package com.dzydowicz.meteoritelandings.db.repository;

import com.dzydowicz.meteoritelandings.models.MeteoriteLandingFields;
import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingFilterTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MeteoriteLandingsRepository implements IMeteoriteLandingsRepository {
    private final MongoTemplate mongoTemplate;

    public MeteoriteLandingTO save(MeteoriteLandingTO meteoriteLandingTO) {
        return mongoTemplate.save(meteoriteLandingTO);
    }

    public List<MeteoriteLandingTO> insertAll(Collection<MeteoriteLandingTO> meteoriteLandingTOs) {
        return new ArrayList<>(mongoTemplate.insertAll(meteoriteLandingTOs));
    }

    public Optional<MeteoriteLandingTO> findById(int id) {
        return Optional.ofNullable(mongoTemplate.findById(id, MeteoriteLandingTO.class));
    }

    public boolean existsById(int id) {
        Query query = new Query(Criteria.where(MeteoriteLandingFields.ID).is(id));
        return mongoTemplate.exists(query, MeteoriteLandingTO.class);
    }

    public void deleteById(int id) {
        Query query = new Query(Criteria.where(MeteoriteLandingFields.ID).is(id));
        mongoTemplate.remove(query, MeteoriteLandingTO.class);
    }

    public Integer obtainHighestId() {
        Integer id = null;
        Query query = new Query()
                .limit(1)
                .with(Sort.by(Sort.Direction.DESC, MeteoriteLandingFields.ID));

        MeteoriteLandingTO meteoriteLandingTO = mongoTemplate.findOne(query, MeteoriteLandingTO.class);

        if (meteoriteLandingTO != null) {
            id = meteoriteLandingTO.getId();
        }

        return id;
    }

    public List<MeteoriteLandingTO> findMeteoriteLandingsByFilter(MeteoriteLandingFilterTO meteoriteLandingFilterTO) {
         Criteria criteria = new Criteria();

         if (meteoriteLandingFilterTO.getIds() != null && !meteoriteLandingFilterTO.getIds().isEmpty()) {
             criteria.andOperator(Criteria.where(MeteoriteLandingFields.ID).in(meteoriteLandingFilterTO.getIds()));
         }

         if (meteoriteLandingFilterTO.getNameType() != null) {
             criteria.andOperator(Criteria.where(MeteoriteLandingFields.NAMETYPE).is(meteoriteLandingFilterTO.getNameType().getLabel()));
         }

         if (meteoriteLandingFilterTO.getFall() != null) {
             criteria.andOperator(Criteria.where(MeteoriteLandingFields.FALL).is(meteoriteLandingFilterTO.getFall().getLabel()));
         }

         if (meteoriteLandingFilterTO.getMinMass() != null) {
             criteria.andOperator(Criteria.where(MeteoriteLandingFields.MASS).gte(meteoriteLandingFilterTO.getMinMass()));
         }

        if (meteoriteLandingFilterTO.getMaxMass() != null) {
            criteria.andOperator(Criteria.where(MeteoriteLandingFields.MASS).lte(meteoriteLandingFilterTO.getMaxMass()));
        }

        if (meteoriteLandingFilterTO.getMinYear() != null) {
            criteria.andOperator(Criteria.where(MeteoriteLandingFields.YEAR).gte(meteoriteLandingFilterTO.getMinYear()));
        }

        if (meteoriteLandingFilterTO.getMaxYear() != null) {
            criteria.andOperator(Criteria.where(MeteoriteLandingFields.YEAR).lte(meteoriteLandingFilterTO.getMaxYear()));
        }

        Query query = new Query(criteria);
        return mongoTemplate.find(query, MeteoriteLandingTO.class);
    }
}
