package com.trackvid.backend.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "Location of measurement")
public class Location {
    @ApiModelProperty(value = "Longitude", example = "52.23241231")
    private double longitude;
    @ApiModelProperty(value = "Latitude", example = "52.23241231")
    private double latitude;
}
