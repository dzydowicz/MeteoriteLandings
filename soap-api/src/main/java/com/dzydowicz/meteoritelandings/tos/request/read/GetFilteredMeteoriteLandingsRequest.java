package com.dzydowicz.meteoritelandings.tos.request.read;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "nametype", "fall", "minMass", "maxMass", "minYear", "maxYear"
})
@XmlRootElement(name = "getMeteoriteLandingsFilteredRequest")
@Data
@NoArgsConstructor
public class GetFilteredMeteoriteLandingsRequest {

    @XmlElement
    private List<Integer> ids;
    @XmlElement
    private MeteoriteLandingNameTypeEnum nametype;
    @XmlElement
    private MeteoriteLandingFallEnum fall;
    @XmlElement
    private Float minMass;
    @XmlElement
    private Float maxMass;
    @XmlElement
    private Integer minYear;
    @XmlElement
    private Integer maxYear;
}
