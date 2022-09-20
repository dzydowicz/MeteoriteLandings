package com.dzydowicz.meteoritelandings.converters;

import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.request.create.SOAPMeteoriteLandingCreationRequestTO;

public class SOAPMeteoriteLandingTOsConverter {

    public static SOAPMeteoriteLandingTO convertToSOAPMeteoriteLandingTO(MeteoriteLandingTO meteoriteLandingTO) {
        return SOAPMeteoriteLandingTO.builder()
                .id(meteoriteLandingTO.getId())
                .name(meteoriteLandingTO.getName())
                .nametype(meteoriteLandingTO.getNameType())
                .recclass(meteoriteLandingTO.getClassification())
                .mass(meteoriteLandingTO.getMass())
                .fall(meteoriteLandingTO.getFall())
                .year(meteoriteLandingTO.getYear())
                .reclat(meteoriteLandingTO.getLatCoordination())
                .reclong(meteoriteLandingTO.getLongCoordination())
                .geoLocation(meteoriteLandingTO.getGeoLocation())
                .build();
    }

    public static MeteoriteLandingCreationTO convertToMeteoriteLandingCreationTO(SOAPMeteoriteLandingCreationRequestTO requestTO) {
        return MeteoriteLandingCreationTO.builder()
                .name(requestTO.getName())
                .nameType(requestTO.getNametype())
                .classification(requestTO.getRecclass())
                .mass(requestTO.getMass())
                .fall(requestTO.getFall())
                .year(requestTO.getYear())
                .latCoordination(requestTO.getReclat())
                .longCoordination(requestTO.getReclong())
                .build();
    }
}
