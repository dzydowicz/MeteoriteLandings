package com.dzydowicz.meteoritelandings.tos.request.update;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id", "name", "nametype", "recclass", "mass", "fall", "year", "reclat", "reclong"
})
@XmlRootElement(name = "meteoriteLanding")
@Data
@NoArgsConstructor
public class SOAPMeteoriteLandingUpdateRequestTO {

    @XmlElement(required = true)
    private Integer id;
    @XmlElement
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
}
