package com.dzydowicz.meteoritelandings.tos.request.create;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "meteoriteLanding"
})
@XmlRootElement(name = "createMeteoriteLandingRequest")
@Data
@NoArgsConstructor
public class CreateMeteoriteLandingsRequest {

    @XmlElement(required = true)
    private SOAPMeteoriteLandingCreationRequestTO meteoriteLanding;
}
