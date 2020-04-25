package com.trackvid.backend.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "trackvid")
public class TrackProperties {

    /**
     * Precision of geo location search
     */
    @NotNull
    private Double geoPrecision;

    /**
     * Precision of time frame search
     */
    @NotNull
    private Long timePrecisionInMinutes;
}