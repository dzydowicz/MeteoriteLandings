package com.dzydowicz.meteoritelandings.tos.response;

import com.dzydowicz.meteoritelandings.tos.SOAPMeteoriteLandingTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "meteoriteLanding"
})
@XmlRootElement(name = "multiCreateMeteoriteLandingsResponse")
@Data
@NoArgsConstructor
public class MultiCreateMeteoriteLandingsResponse {

    @XmlElement
    private List<SOAPMeteoriteLandingTO> meteoriteLanding;
}
