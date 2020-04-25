package com.trackvid.backend.service;

import com.trackvid.backend.domain.Measurements;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementService {
    private final MeasurementAddService measurementAddService;

    public void addMeasurements(final Measurements measurements) {
        measurements.getMeasurements().forEach(measurementAddService::addMeasurement);
    }
}
