package com.dzydowicz.meteoritelandings.tos.request.remove;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id"
})
@XmlRootElement(name = "removeMeteoriteLandingRequest")
@Data
@NoArgsConstructor
public class RemoveMeteoriteLandingRequest {

    @XmlElement(required = true)
    private int id;
}
