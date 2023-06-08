package com.dzydowicz.meteoritelandings.tos.response.read;

import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "meteoriteLanding"
})
@XmlRootElement(name = "getMeteoriteLandingsFilteredResponse")
@Data
@NoArgsConstructor
public class GetFilteredMeteoriteLandingsResponse {

    @XmlElement
    private List<SOAPMeteoriteLandingTO> meteoriteLanding;
}
