package com.dzydowicz.meteoritelandings.tos;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeteoriteLandingCreationTO {
    private String name;
    private MeteoriteLandingNameTypeEnum nameType;
    private String classification;
    private float mass;
    private MeteoriteLandingFallEnum fall;
    private int year;
    private float latCoordination;
    private float longCoordination;
}
