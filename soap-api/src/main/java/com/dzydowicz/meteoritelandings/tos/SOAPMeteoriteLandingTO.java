package com.dzydowicz.meteoritelandings.tos;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id", "name", "nameType", "recclass", "mass", "fall", "year", "reclat", "reclong", "geoLocation"
})
@XmlRootElement(name = "meteoriteLanding")
@Data
@NoArgsConstructor
@Builder
public class SOAPMeteoriteLandingTO {

    @XmlElement(required = true)
    private int id;

    @XmlElement(required = true)
    private String name;

    private MeteoriteLandingNameTypeEnum nameType;
    private String recclass;
    private Float mass;
    private MeteoriteLandingFallEnum fall;
    private Integer year;
    private Float reclat;
    private Float reclong;
    private String geoLocation;
}
