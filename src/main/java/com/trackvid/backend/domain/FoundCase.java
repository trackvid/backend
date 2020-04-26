package com.trackvid.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trackvid.backend.config.AppConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Data of found cases for adequate measurement.")
public class FoundCase {

    @JsonFormat(pattern = AppConfig.DATE_TIME_FORMAT)
    @ApiModelProperty(value = "Date of Measurement", example = "2020-04-25-13:04")
    private LocalDateTime date;

    @ApiModelProperty(value = "Number of cases in close proximity", example = "3")
    private long numberOfInfected;

    @ApiModelProperty(value = "location where are you could meet infected people")
    private Location location;
}
