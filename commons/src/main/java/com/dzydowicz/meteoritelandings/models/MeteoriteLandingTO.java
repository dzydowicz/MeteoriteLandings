package com.dzydowicz.meteoritelandings.models;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "MeteoriteLandings")
@Builder
public class MeteoriteLandingTO {

    @MongoId
    private int id;
    private String name;
    private MeteoriteLandingNameTypeEnum nameType;

    @Field("recclass")
    private String classification;

    private Float mass;
    private MeteoriteLandingFallEnum fall;
    private Integer year;

    @Field("reclat")
    private Float latCoordination;

    @Field("reclong")
    private Float longCoordination;

    private String geoLocation;
}
