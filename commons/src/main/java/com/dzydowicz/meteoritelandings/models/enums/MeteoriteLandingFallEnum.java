package com.dzydowicz.meteoritelandings.models.enums;

import lombok.Getter;

public enum MeteoriteLandingFallEnum {
    FELL("Fell"),
    FOUND("Found");

    @Getter
    private final String label;

    MeteoriteLandingFallEnum(String label) {
        this.label = label;
    }
}
