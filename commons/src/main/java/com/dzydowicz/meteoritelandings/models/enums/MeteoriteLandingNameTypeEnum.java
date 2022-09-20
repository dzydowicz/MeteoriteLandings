package com.dzydowicz.meteoritelandings.models.enums;

import lombok.Getter;

public enum MeteoriteLandingNameTypeEnum {
    RELICT("Reject"),
    VALID("Valid");

    @Getter
    private final String label;

    MeteoriteLandingNameTypeEnum(String label) {
        this.label = label;
    }
}
