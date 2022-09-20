package com.dzydowicz.meteoritelandings.converters;

import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;

public class SOAPMeteoriteLandingTOConverter {

    public static SOAPMeteoriteLandingTO convertToSOAPMeteoriteLandingTO(MeteoriteLandingTO meteoriteLandingTO) {
        return SOAPMeteoriteLandingTO.builder()
                .id(meteoriteLandingTO.getId())
                .name(meteoriteLandingTO.getName())
                .nameType(meteoriteLandingTO.getNameType())
                .recclass(meteoriteLandingTO.getClassification())
                .mass(meteoriteLandingTO.getMass())
                .fall(meteoriteLandingTO.getFall())
                .year(meteoriteLandingTO.getYear())
                .reclat(meteoriteLandingTO.getLatCoordination())
                .reclong(meteoriteLandingTO.getLongCoordination())
                .geoLocation(meteoriteLandingTO.getGeoLocation())
                .build();
    }
}
