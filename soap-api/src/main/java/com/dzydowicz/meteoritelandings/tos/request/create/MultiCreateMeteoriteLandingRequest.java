package com.dzydowicz.meteoritelandings.tos.request.create;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "meteoriteLanding"
})
@XmlRootElement(name = "multiCreateMeteoriteLandingsRequest")
@Data
@NoArgsConstructor
public class MultiCreateMeteoriteLandingRequest {

    @XmlElement
    private List<SOAPMeteoriteLandingCreationRequestTO> meteoriteLanding;
}
