package com.trackvid.backend.config;

import com.trackvid.backend.config.properties.TrackProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TrackProperties.class)
public class AppConfig {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd-HH:mm";
    public static final String TIME_FORMAT = "HH:mm";
}
