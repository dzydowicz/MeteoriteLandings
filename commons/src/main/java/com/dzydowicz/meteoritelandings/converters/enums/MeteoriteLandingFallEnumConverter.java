package com.dzydowicz.meteoritelandings.converters.enums;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

public class MeteoriteLandingFallEnumConverter {

    @WritingConverter
    public static final class MeteoriteLandingFallEnumWriteConverter implements Converter<MeteoriteLandingFallEnum, String> {
        @Override
        public String convert(MeteoriteLandingFallEnum nameTypeEnum) {
            return nameTypeEnum == null ? "" : nameTypeEnum.getLabel();
        }
    }

    @ReadingConverter
    public static final class MeteoriteLandingFallEnumReadConverter implements Converter<String, MeteoriteLandingFallEnum> {
        @Override
        public MeteoriteLandingFallEnum convert(String label) {
            return label == null ? null : MeteoriteLandingFallEnum.valueOf(label.toUpperCase());
        }
    }
}
