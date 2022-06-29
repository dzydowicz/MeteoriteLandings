package com.dzydowicz.meteoritelandings.models;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class MeteoriteLandingTO {

    @Id
    private int id;
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

    private String geoLocation;
}
