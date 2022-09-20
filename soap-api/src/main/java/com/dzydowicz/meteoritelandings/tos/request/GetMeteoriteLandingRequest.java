package com.dzydowicz.meteoritelandings.tos.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id"
})
@XmlRootElement(name = "getMeteoriteLandingRequest")
@Data
@NoArgsConstructor
public class GetMeteoriteLandingRequest {

    @XmlElement(required = true)
    private int id;
}
