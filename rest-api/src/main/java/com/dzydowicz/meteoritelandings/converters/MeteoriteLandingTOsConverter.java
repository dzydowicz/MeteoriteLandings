package com.dzydowicz.meteoritelandings.converters;

import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingUpdateTO;
import com.dzydowicz.meteoritelandings.tos.create.MeteoriteLandingCreationRequestTO;
import com.dzydowicz.meteoritelandings.tos.update.MeteoriteLandingUpdateRequestTO;

public class MeteoriteLandingTOsConverter {

    public static MeteoriteLandingCreationTO convertToMeteoriteLandingCreationTO(MeteoriteLandingCreationRequestTO requestTO) {
        return MeteoriteLandingCreationTO.builder()
                .name(requestTO.getName())
                .nameType(requestTO.getNameType())
                .classification(requestTO.getClassification())
                .mass(requestTO.getMass())
                .year(requestTO.getYear())
                .latCoordination(requestTO.getLatCoordination())
                .longCoordination(requestTO.getLongCoordination())
                .build();
    }

    public static MeteoriteLandingUpdateTO convertToMeteoriteLandingUpdateTO(MeteoriteLandingUpdateRequestTO requestTO) {
        return MeteoriteLandingUpdateTO.builder()
                .name(requestTO.getName())
                .nameType(requestTO.getNameType())
                .classification(requestTO.getClassification())
                .mass(requestTO.getMass())
                .year(requestTO.getYear())
                .latCoordination(requestTO.getLatCoordination())
                .longCoordination(requestTO.getLongCoordination())
                .build();
    }
}
