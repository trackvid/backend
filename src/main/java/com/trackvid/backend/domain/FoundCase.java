package com.trackvid.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trackvid.backend.config.AppConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoundCase {

    @JsonFormat(pattern = AppConfig.DATE_TIME_FORMAT)
    private LocalDateTime dateTime;
    private long numberOfInfected;
}
