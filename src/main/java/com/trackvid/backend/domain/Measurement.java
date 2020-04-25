package com.trackvid.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trackvid.backend.config.AppConfig;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Measurement {

    @JsonFormat(pattern = AppConfig.DATE_TIME_FORMAT)
    private LocalDateTime measurementDate;
    private Location location;
}
