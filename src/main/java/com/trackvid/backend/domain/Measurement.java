package com.trackvid.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trackvid.backend.config.AppConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel(value = "Single Measurement Data")
public class Measurement {

    @JsonFormat(pattern = AppConfig.DATE_TIME_FORMAT)
    @ApiModelProperty(value = "Date of Measurement", example = "2020-04-25-13:04")
    private LocalDateTime date;

    @ApiModelProperty(value = "Location of measurement")
    private Location location;
}
