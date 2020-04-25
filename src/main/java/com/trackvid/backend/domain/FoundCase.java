package com.trackvid.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm")
    private LocalDateTime localDateTime;
    private long numberOfInfected;
}
