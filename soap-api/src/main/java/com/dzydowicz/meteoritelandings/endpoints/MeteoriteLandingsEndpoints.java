package com.dzydowicz.meteoritelandings.endpoints;

import com.dzydowicz.meteoritelandings.converters.SOAPMeteoriteLandingTOConverter;
import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.services.MeteoriteLandingsService;
import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.request.GetMeteoriteLandingRequest;
import com.dzydowicz.meteoritelandings.tos.response.GetMeteoriteLandingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
        SOAPMeteoriteLandingTO soapMeteoriteLandingTO = SOAPMeteoriteLandingTOConverter.convertToSOAPMeteoriteLandingTO(meteoriteLandingTO);

        GetMeteoriteLandingResponse response = new GetMeteoriteLandingResponse();
        response.setMeteoriteLanding(soapMeteoriteLandingTO);

        return response;
    }
}
