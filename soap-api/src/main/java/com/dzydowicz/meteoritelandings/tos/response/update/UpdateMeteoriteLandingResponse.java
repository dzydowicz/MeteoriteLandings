package com.dzydowicz.meteoritelandings.tos.response.update;

import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "meteoriteLanding"
})
@XmlRootElement(name = "updateMeteoriteLandingResponse")
@Data
@NoArgsConstructor
public class UpdateMeteoriteLandingResponse {

    @XmlElement
    private SOAPMeteoriteLandingTO meteoriteLanding;
}
