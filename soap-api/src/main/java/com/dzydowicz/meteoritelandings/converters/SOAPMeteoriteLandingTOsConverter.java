package com.dzydowicz.meteoritelandings.converters;

import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingFilterTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingUpdateTO;
import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.request.create.SOAPMeteoriteLandingCreationRequestTO;
import com.dzydowicz.meteoritelandings.tos.request.read.GetFilteredMeteoriteLandingsRequest;
import com.dzydowicz.meteoritelandings.tos.request.update.SOAPMeteoriteLandingUpdateRequestTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<SOAPMeteoriteLandingTO> convertTOSOAPMeteoriteLandingTOsList(List<MeteoriteLandingTO> meteoriteLandingTOsList) {
        return meteoriteLandingTOsList.stream()
                .map(SOAPMeteoriteLandingTOsConverter::convertToSOAPMeteoriteLandingTO)
                .collect(Collectors.toList());
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

    public static List<MeteoriteLandingCreationTO> convertToMeteoriteLandingCreationTOsList(List<SOAPMeteoriteLandingCreationRequestTO> requestTO) {
        return requestTO.stream()
                .map(SOAPMeteoriteLandingTOsConverter::convertToMeteoriteLandingCreationTO)
                .collect(Collectors.toList());
    }

    public static MeteoriteLandingUpdateTO convertToMeteoriteLandingUpdateTO(SOAPMeteoriteLandingUpdateRequestTO requestTO) {
        return MeteoriteLandingUpdateTO.builder()
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

    public static MeteoriteLandingFilterTO convertToMeteoriteLandingFilterTO(GetFilteredMeteoriteLandingsRequest requestTO) {
        return MeteoriteLandingFilterTO.builder()
                .ids(requestTO.getIds())
                .nameType(requestTO.getNametype())
                .fall(requestTO.getFall())
                .minMass(requestTO.getMinMass())
                .maxMass(requestTO.getMaxMass())
                .minYear(requestTO.getMinYear())
                .maxYear(requestTO.getMaxYear())
                .build();
    }
}
