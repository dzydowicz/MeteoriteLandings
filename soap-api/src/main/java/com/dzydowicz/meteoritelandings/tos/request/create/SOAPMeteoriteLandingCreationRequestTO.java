package com.dzydowicz.meteoritelandings.tos.request.create;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name", "nametype", "recclass", "mass", "fall", "year", "reclat", "reclong"
})
@XmlRootElement(name = "meteoriteLanding")
@Data
@NoArgsConstructor
public class SOAPMeteoriteLandingCreationRequestTO {

    @XmlElement(required = true)
    private String name;
    @XmlElement
    private MeteoriteLandingNameTypeEnum nametype;
    @XmlElement
    private String recclass;
    @XmlElement
    private float mass;
    @XmlElement
    private MeteoriteLandingFallEnum fall;
    @XmlElement
    private int year;
    @XmlElement
    private float reclat;
    @XmlElement
    private float reclong;
}
