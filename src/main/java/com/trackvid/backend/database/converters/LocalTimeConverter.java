package com.trackvid.backend.database.converters;

import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeConverter implements AttributeConverter<LocalTime, String> {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String toGraphProperty(final LocalTime value) {
        return value.format(DATE_TIME_FORMATTER);
    }

    @Override
    public LocalTime toEntityAttribute(final String value) {
        return LocalTime.parse(value, DATE_TIME_FORMATTER);
    }
}