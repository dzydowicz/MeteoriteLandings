package com.dzydowicz.meteoritelandings.db.repository;

import com.dzydowicz.meteoritelandings.exceptions.MeteoriteLandingNotFoundException;
import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingFilterTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingUpdateTO;

import java.util.List;

public interface IMeteoriteLandingsService {

    MeteoriteLandingTO findMeteoriteLanding(int meteoriteLandingId) throws MeteoriteLandingNotFoundException;

    List<MeteoriteLandingTO> getFilteredMeteoriteLandings(MeteoriteLandingFilterTO meteoriteLandingFilterTO);

    MeteoriteLandingTO updateMeteoriteLanding(int meteoriteLandingId, MeteoriteLandingUpdateTO meteoriteLandingUpdateTO) throws MeteoriteLandingNotFoundException;

    List<MeteoriteLandingTO> createMultipleMeteoriteLandings(List<MeteoriteLandingCreationTO> meteoriteLandingCreationTOs);

    MeteoriteLandingTO createMeteoriteLanding(MeteoriteLandingCreationTO meteoriteLandingCreationTO);

    void removeMeteoriteLanding(int meteoriteLandingId) throws MeteoriteLandingNotFoundException;
}
