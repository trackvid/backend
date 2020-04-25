package com.trackvid.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Measurement {

    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
    private LocalDateTime measurementDate;
    private Location location;
}
