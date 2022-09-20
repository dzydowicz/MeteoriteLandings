package com.dzydowicz.meteoritelandings.tos.request.update;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "meteoriteLanding"
})
@XmlRootElement(name = "updateMeteoriteLandingRequest")
@Data
@NoArgsConstructor
public class UpdateMeteoriteLandingRequest {

    @XmlElement
    private SOAPMeteoriteLandingUpdateRequestTO meteoriteLanding;
}
