package com.trackvid.backend.service;

import com.trackvid.backend.database.repository.MeasurementDayRepository;
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
    private final MeasurementDayRepository measurementDayRepository;
    private final MeasurementTimeRepository measurementTimeRepository;
    private final MeasurementLocationRepository measurementLocationRepository;

    public void addMeasurements(final Measurements measurements) {
        measurements.getMeasurements().forEach(measurementAddService::addMeasurement);
    }

    public List<FoundCase> getAllCasesNearMeasurements(final Measurements measurements) {
        final List<FoundCase> foundCases = new ArrayList<>();
        measurements.getMeasurements().forEach(measurement -> addFoundCaseForMeasurement(measurement, foundCases));

        return foundCases;
    }

    private void addFoundCaseForMeasurement(final Measurement measurement, final List<FoundCase> foundCases) {
        final var measurementTime = measurementTimeRepository.findByTimeAndAndMeasurementTimeEdge_MeasurementDay_DayDate(
                measurement.getMeasurementDate().toLocalTime(),
                measurement.getMeasurementDate().toLocalDate());
        if (measurementTime.isEmpty()) {
            return;
        }
        final var location = measurement.getLocation();
        final var numberOfInfected = measurementLocationRepository.findAllByLatitudeBetweenAndAndLongitudeBetweenAndMeasurementEdge_MeasurementTime_Id(
                location.getLatitude() - 5,
                location.getLatitude() + 5,
                location.getLongitude() - 5,
                location.getLongitude() + 5,
                measurementTime.get().getId()
        ).size();
        if (numberOfInfected == 0) {
            return;
        }
        final var foundCase = FoundCase.builder()
                .localDateTime(measurement.getMeasurementDate())
                .numberOfInfected(numberOfInfected)
                .build();
        foundCases.add(foundCase);
    }
}
