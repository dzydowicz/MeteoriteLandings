package com.dzydowicz.meteoritelandings.tos;

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

    private float mass;
    private MeteoriteLandingFallEnum fall;
    private int year;

    @JsonProperty("reclat")
    private float latCoordination;

    @JsonProperty("reclong")
    private float longCoordination;
}
