package com.algaworks.algasensors.device.management.api.config.jpa;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TSIDToLongJPAAttributeConverter
        implements AttributeConverter<TSID, Long> {

    // Converte de TSID para long
    @Override
    public Long convertToDatabaseColumn(TSID attribute) {
        return attribute.toLong();
    }

    // Converte de long para TSID
    @Override
    public TSID convertToEntityAttribute(Long dbData) {
        return TSID.from(dbData);
    }
}
