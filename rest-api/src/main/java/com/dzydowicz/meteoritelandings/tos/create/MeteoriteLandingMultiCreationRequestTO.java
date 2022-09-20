package com.dzydowicz.meteoritelandings.tos.create;

import lombok.Data;
import java.util.List;

@Data
public class MeteoriteLandingMultiCreationRequestTO {
    private List<MeteoriteLandingCreationRequestTO> meteoriteLandings;
}
