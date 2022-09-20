package com.dzydowicz.meteoritelandings.endpoints;

import com.dzydowicz.meteoritelandings.converters.SOAPMeteoriteLandingTOsConverter;
import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.services.MeteoriteLandingsService;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingUpdateTO;
import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.request.read.GetMeteoriteLandingRequest;
import com.dzydowicz.meteoritelandings.tos.request.create.CreateMeteoriteLandingsRequest;
import com.dzydowicz.meteoritelandings.tos.request.create.MultiCreateMeteoriteLandingRequest;
import com.dzydowicz.meteoritelandings.tos.request.remove.RemoveMeteoriteLandingRequest;
import com.dzydowicz.meteoritelandings.tos.request.update.SOAPMeteoriteLandingUpdateRequestTO;
import com.dzydowicz.meteoritelandings.tos.request.update.UpdateMeteoriteLandingRequest;
import com.dzydowicz.meteoritelandings.tos.response.read.GetMeteoriteLandingResponse;
import com.dzydowicz.meteoritelandings.tos.response.create.CreateMeteoriteLandingResponse;
import com.dzydowicz.meteoritelandings.tos.response.create.MultiCreateMeteoriteLandingsResponse;
import com.dzydowicz.meteoritelandings.tos.response.remove.RemoveMeteoriteLandingResponse;
import com.dzydowicz.meteoritelandings.tos.response.update.UpdateMeteoriteLandingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class MeteoriteLandingsEndpoints {

    private MeteoriteLandingsService meteoriteLandingsService;

    @Autowired
    public MeteoriteLandingsEndpoints(MeteoriteLandingsService meteoriteLandingsService) {
        this.meteoriteLandingsService = meteoriteLandingsService;
    }

    @PayloadRoot(localPart = "getMeteoriteLandingRequest")
    @ResponsePayload
    public GetMeteoriteLandingResponse getMeteoriteLanding(@RequestPayload GetMeteoriteLandingRequest request) {
        MeteoriteLandingTO meteoriteLandingTO = meteoriteLandingsService.findMeteoriteLanding(request.getId());
        SOAPMeteoriteLandingTO soapMeteoriteLandingTO = SOAPMeteoriteLandingTOsConverter.convertToSOAPMeteoriteLandingTO(meteoriteLandingTO);

        GetMeteoriteLandingResponse response = new GetMeteoriteLandingResponse();
        response.setMeteoriteLanding(soapMeteoriteLandingTO);

        return response;
    }

    @PayloadRoot(localPart = "createMeteoriteLandingRequest")
    @ResponsePayload
    public CreateMeteoriteLandingResponse createMeteoriteLanding(@RequestPayload CreateMeteoriteLandingsRequest request) {
        MeteoriteLandingCreationTO meteoriteLandingCreationTO = SOAPMeteoriteLandingTOsConverter.convertToMeteoriteLandingCreationTO(request.getMeteoriteLanding());
        MeteoriteLandingTO meteoriteLanding = meteoriteLandingsService.createMeteoriteLanding(meteoriteLandingCreationTO);
        SOAPMeteoriteLandingTO soapMeteoriteLandingTO = SOAPMeteoriteLandingTOsConverter.convertToSOAPMeteoriteLandingTO(meteoriteLanding);

        CreateMeteoriteLandingResponse response = new CreateMeteoriteLandingResponse();
        response.setMeteoriteLanding(soapMeteoriteLandingTO);

        return response;
    }

    @PayloadRoot(localPart = "multiCreateMeteoriteLandingsRequest")
    @ResponsePayload
    public MultiCreateMeteoriteLandingsResponse multiCreateMeteoriteLandings(@RequestPayload MultiCreateMeteoriteLandingRequest request) {

        List<MeteoriteLandingCreationTO> meteoriteLandingCreationTOs = request.getMeteoriteLanding().stream()
                .map(SOAPMeteoriteLandingTOsConverter::convertToMeteoriteLandingCreationTO)
                .collect(Collectors.toList());

        List<MeteoriteLandingTO> meteoriteLandingsList = meteoriteLandingsService.createMultipleMeteoriteLandings(meteoriteLandingCreationTOs);

        List<SOAPMeteoriteLandingTO> soapMeteoriteLandingTOs = meteoriteLandingsList.stream()
                .map(SOAPMeteoriteLandingTOsConverter::convertToSOAPMeteoriteLandingTO)
                .collect(Collectors.toList());

        MultiCreateMeteoriteLandingsResponse response = new MultiCreateMeteoriteLandingsResponse();
        response.setMeteoriteLanding(soapMeteoriteLandingTOs);

        return response;
    }

    @PayloadRoot(localPart = "updateMeteoriteLandingRequest")
    @ResponsePayload
    public UpdateMeteoriteLandingResponse updateMeteoriteLanding(@RequestPayload UpdateMeteoriteLandingRequest request) {

        SOAPMeteoriteLandingUpdateRequestTO soapMeteoriteLandingUpdateTO = request.getMeteoriteLanding();
        Integer id = soapMeteoriteLandingUpdateTO.getId();

        MeteoriteLandingUpdateTO meteoriteLandingUpdateTO = SOAPMeteoriteLandingTOsConverter.convertToMeteoriteLandingUpdateTO(soapMeteoriteLandingUpdateTO);

        MeteoriteLandingTO meteoriteLandingTO = meteoriteLandingsService.updateMeteoriteLanding(id, meteoriteLandingUpdateTO);
        SOAPMeteoriteLandingTO soapMeteoriteLandingTO = SOAPMeteoriteLandingTOsConverter.convertToSOAPMeteoriteLandingTO(meteoriteLandingTO);

        UpdateMeteoriteLandingResponse response = new UpdateMeteoriteLandingResponse();
        response.setMeteoriteLanding(soapMeteoriteLandingTO);

        return response;
    }

    @PayloadRoot(localPart = "removeMeteoriteLandingRequest")
    public RemoveMeteoriteLandingResponse removeMeteoriteLanding(@RequestPayload RemoveMeteoriteLandingRequest request) {

        meteoriteLandingsService.removeMeteoriteLanding(request.getId());

        RemoveMeteoriteLandingResponse response = new RemoveMeteoriteLandingResponse();
        response.setResponse("Meteorite landing with id " + request.getId() + "correctly removed.");

        return response;
    }
}
