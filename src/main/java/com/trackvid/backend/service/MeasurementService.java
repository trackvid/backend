package com.trackvid.backend.service;

import com.trackvid.backend.config.properties.TrackProperties;
import com.trackvid.backend.database.repository.MeasurementLocationRepository;
import com.trackvid.backend.database.repository.MeasurementTimeRepository;
import com.trackvid.backend.domain.FoundCase;
import com.trackvid.backend.domain.Measurement;
import com.trackvid.backend.domain.Measurements;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementService {
    private final MeasurementAddService measurementAddService;
    private final MeasurementTimeRepository measurementTimeRepository;
    private final MeasurementLocationRepository measurementLocationRepository;
    private final TrackProperties trackProperties;

    public void addMeasurements(final Measurements measurements) {
        measurements.getMeasurements().forEach(measurementAddService::addMeasurement);
    }

    public List<FoundCase> getAllCasesNearMeasurements(final Measurements measurements) {
        final List<FoundCase> foundCases = new ArrayList<>();
        measurements.getMeasurements().forEach(measurement -> addFoundCaseForMeasurement(measurement, foundCases));

        return foundCases;
    }

    private void addFoundCaseForMeasurement(final Measurement measurement, final List<FoundCase> foundCases) {
        final var measurementTimes = measurementTimeRepository.findAllByTimeBetweenAndAndMeasurementTimeEdge_MeasurementDay_DayDate(
                measurement.getDate().toLocalTime().minusMinutes(trackProperties.getTimePrecisionInMinutes()),
                measurement.getDate().toLocalTime().plusMinutes(trackProperties.getTimePrecisionInMinutes()),
                measurement.getDate().toLocalDate());
        if (measurementTimes.isEmpty()) {
            return;
        }
        final var location = measurement.getLocation();
        var numberOfInfected = 0;
        for (final var measurementTime : measurementTimes) {
            numberOfInfected += measurementLocationRepository.findAllByLatitudeBetweenAndAndLongitudeBetweenAndMeasurementEdge_MeasurementTime_Id(
                    location.getLatitude() - trackProperties.getGeoPrecision(),
                    location.getLatitude() + trackProperties.getGeoPrecision(),
                    location.getLongitude() - trackProperties.getGeoPrecision(),
                    location.getLongitude() + trackProperties.getGeoPrecision(),
                    measurementTime.getId()
            ).size();
        }
        if (numberOfInfected == 0) {
            return;
        }
        final var foundCase = FoundCase.builder()
                .date(measurement.getDate())
                .numberOfInfected(numberOfInfected)
                .build();
        foundCases.add(foundCase);
    }
}
