package com.dzydowicz.meteoritelandings.tos;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MeteoriteLandingFilterTO {
    private List<Integer> ids;
    private MeteoriteLandingNameTypeEnum nameType;
    private MeteoriteLandingFallEnum fall;
    private float minMass;
    private float maxMass;
    private float minYear;
    private float maxYear;
}
