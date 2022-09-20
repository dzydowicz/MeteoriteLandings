package com.dzydowicz.meteoritelandings.tos.create;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MeteoriteLandingCreationRequestTO {
    private String name;

    @JsonProperty("nametype")
    private MeteoriteLandingNameTypeEnum nameType;

    @JsonProperty("recclass")
    private String classification;

    private Float mass;
    private MeteoriteLandingFallEnum fall;
    private Integer year;

    @JsonProperty("reclat")
    private Float latCoordination;

    @JsonProperty("reclong")
    private Float longCoordination;
}
