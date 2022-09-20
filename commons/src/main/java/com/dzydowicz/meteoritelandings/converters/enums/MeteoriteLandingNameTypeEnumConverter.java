package com.dzydowicz.meteoritelandings.converters.enums;

import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

public class MeteoriteLandingNameTypeEnumConverter {

    @WritingConverter
    public static final class MeteoriteLandingNameTypeEnumWriteConverter implements Converter<MeteoriteLandingNameTypeEnum, String> {
        @Override
        public String convert(MeteoriteLandingNameTypeEnum nameTypeEnum) {
            return nameTypeEnum == null ? "" : nameTypeEnum.getLabel();
        }
    }

    @ReadingConverter
    public static final class MeteoriteLandingNameTypeEnumReadConverter implements Converter<String, MeteoriteLandingNameTypeEnum> {
        @Override
        public MeteoriteLandingNameTypeEnum convert(String label) {
            return label == null ? null : MeteoriteLandingNameTypeEnum.valueOf(label.toUpperCase());
        }
    }
}
