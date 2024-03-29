package com.dzydowicz.meteoritelandings.tos;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id", "name", "nametype", "recclass", "mass", "fall", "year", "reclat", "reclong", "geoLocation"
})
@XmlRootElement(name = "meteoriteLanding")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SOAPMeteoriteLandingTO {

    @XmlElement(required = true)
    private int id;

    @XmlElement(required = true)
    private String name;

    @XmlElement
    private MeteoriteLandingNameTypeEnum nametype;
    @XmlElement
    private String recclass;
    @XmlElement
    private Float mass;
    @XmlElement
    private MeteoriteLandingFallEnum fall;
    @XmlElement
    private Integer year;
    @XmlElement
    private Float reclat;
    @XmlElement
    private Float reclong;
    @XmlElement
    private String geoLocation;
}
