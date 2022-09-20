package com.dzydowicz.meteoritelandings.tos.response.remove;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "response"
})
@XmlRootElement(name = "removeMeteoriteLandingResponse")
@Data
@NoArgsConstructor
public class RemoveMeteoriteLandingResponse {

    @XmlElement
    private String response;
}
