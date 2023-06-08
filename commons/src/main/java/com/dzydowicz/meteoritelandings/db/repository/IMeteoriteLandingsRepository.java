package com.dzydowicz.meteoritelandings.db.repository;

import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingFilterTO;

import java.util.List;
import java.util.Optional;

public interface IMeteoriteLandingsRepository {

    Optional<MeteoriteLandingTO> findById(int id);

    boolean existsById(int id);

    void deleteById(int id);

    List<MeteoriteLandingTO> findMeteoriteLandingsByFilter(MeteoriteLandingFilterTO meteoriteLandingFilterTO);
}
