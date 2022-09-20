package com.dzydowicz.meteoritelandings.tos.response;

import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "meteoriteLanding"
})
@XmlRootElement(name = "getMeteoriteLandingResponse")
@Data
@NoArgsConstructor
public class GetMeteoriteLandingResponse {

    @XmlElement
    private SOAPMeteoriteLandingTO meteoriteLanding;
}
