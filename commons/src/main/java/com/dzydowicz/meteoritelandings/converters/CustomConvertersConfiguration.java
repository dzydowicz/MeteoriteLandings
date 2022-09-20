package com.dzydowicz.meteoritelandings.converters;

import com.dzydowicz.meteoritelandings.converters.enums.MeteoriteLandingFallEnumConverter.MeteoriteLandingFallEnumReadConverter;
import com.dzydowicz.meteoritelandings.converters.enums.MeteoriteLandingFallEnumConverter.MeteoriteLandingFallEnumWriteConverter;
import com.dzydowicz.meteoritelandings.converters.enums.MeteoriteLandingNameTypeEnumConverter.MeteoriteLandingNameTypeEnumReadConverter;
import com.dzydowicz.meteoritelandings.converters.enums.MeteoriteLandingNameTypeEnumConverter.MeteoriteLandingNameTypeEnumWriteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomConvertersConfiguration {

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();

        converterList.add(new MeteoriteLandingFallEnumWriteConverter());
        converterList.add(new MeteoriteLandingFallEnumReadConverter());
        converterList.add(new MeteoriteLandingNameTypeEnumWriteConverter());
        converterList.add(new MeteoriteLandingNameTypeEnumReadConverter());

        return new MongoCustomConversions(converterList);
    }
}
