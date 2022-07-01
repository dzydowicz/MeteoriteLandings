package com.dzydowicz.meteoritelandings.db.repository;

import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MeteoriteLandingsRepository extends MongoRepository<MeteoriteLandingTO, String> {

    Optional<MeteoriteLandingTO> findById(int id);

    boolean existsById(int id);

    void deleteById(int id);

    int findWithHighestId();

    List<MeteoriteLandingTO> findAll(Query query);
}
