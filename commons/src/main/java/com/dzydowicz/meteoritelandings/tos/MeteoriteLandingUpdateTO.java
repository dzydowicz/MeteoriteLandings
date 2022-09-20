package com.dzydowicz.meteoritelandings.tos;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MeteoriteLandingUpdateTO {
    private String name;
    private MeteoriteLandingNameTypeEnum nameType;
    private String classification;
    private Float mass;
    private MeteoriteLandingFallEnum fall;
    private Integer year;
    private Float latCoordination;
    private Float longCoordination;
}
