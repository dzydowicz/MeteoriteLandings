package com.dzydowicz.meteoritelandings.converters;

import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationRequestTO;

public class MeteoriteLandingTOsConverter {

    public static MeteoriteLandingCreationTO convertToMeteoriteLandingCreationTO(MeteoriteLandingCreationRequestTO requestTO) {
        return new MeteoriteLandingCreationTO(requestTO.getName(), requestTO.getNameType(), requestTO.getClassification(), requestTO.getMass(),
                requestTO.getFall(), requestTO.getYear(), requestTO.getLatCoordination(), requestTO.getLongCoordination());
    }
}
