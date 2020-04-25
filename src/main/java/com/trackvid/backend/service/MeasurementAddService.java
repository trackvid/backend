package com.trackvid.backend.service;

import com.trackvid.backend.database.domain.edges.MeasurementEdge;
import com.trackvid.backend.database.domain.edges.MeasurementTimeEdge;
import com.trackvid.backend.database.domain.nodes.MeasurementDay;
import com.trackvid.backend.database.domain.nodes.MeasurementLocation;
import com.trackvid.backend.database.domain.nodes.MeasurementTime;
import com.trackvid.backend.database.repository.MeasurementDayRepository;
import com.trackvid.backend.database.repository.MeasurementLocationRepository;
import com.trackvid.backend.database.repository.MeasurementTimeRepository;
import com.trackvid.backend.domain.Measurement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MeasurementAddService {
    private final MeasurementDayRepository measurementDayRepository;
    private final MeasurementTimeRepository measurementTimeRepository;
    private final MeasurementLocationRepository measurementLocationRepository;

    @Transactional
    public void addMeasurement(final Measurement measurement) {
        final var measurementDay = getMeasurementDay(measurement);
        final var measurementTime = getMeasurementTime(measurement, measurementDay);
        final var measurementLocation = getMeasurementLocation(measurement, measurementTime);
        measurementLocationRepository.save(measurementLocation);


    }

    MeasurementDay getMeasurementDay(final Measurement measurement) {
        return measurementDayRepository.findByDayDate(measurement.getMeasurementDate().toLocalDate())
                .orElseGet(() -> createMeasurementDayFromMeasurement(measurement));
    }

    private MeasurementDay createMeasurementDayFromMeasurement(final Measurement measurement) {
        return MeasurementDay.builder()
                .dayDate(measurement.getMeasurementDate().toLocalDate())
                .build();
    }

    private MeasurementTime getMeasurementTime(final Measurement measurement, final MeasurementDay measurementDay) {
        if (measurementDay.getId() == null) {
            return createMeasurementTimeFromMeasurement(measurement, measurementDay);
        } else {
            return measurementTimeRepository.findByTimeAndAndMeasurementTimeEdge_MeasurementDay_DayDate(measurement.getMeasurementDate().toLocalTime(), measurementDay.getDayDate())
                    .orElseGet(() -> createMeasurementTimeFromMeasurement(measurement, measurementDay));
        }
    }

    private MeasurementTime createMeasurementTimeFromMeasurement(final Measurement measurement, final MeasurementDay measurementDay) {
        final var measurementTime = MeasurementTime.builder()
                .time(measurement.getMeasurementDate().toLocalTime())
                .build();
        final var measurementTimeEdge = MeasurementTimeEdge.builder()
                .measurementDay(measurementDay)
                .measurementTime(measurementTime)
                .build();
        measurementTime.setMeasurementTimeEdge(measurementTimeEdge);
        measurementDay.getMeasurementTimeEdges().add(measurementTimeEdge);

        return measurementTime;
    }

    private MeasurementLocation getMeasurementLocation(final Measurement measurement, final MeasurementTime measurementTime) {
        final var measurementLocation = MeasurementLocation.builder()
                .latitude(measurement.getLocation().getLatitude())
                .longitude(measurement.getLocation().getLongitude())
                .build();
        final var measurementEdge = MeasurementEdge.builder()
                .measurementLocation(measurementLocation)
                .measurementTime(measurementTime)
                .build();
        measurementLocation.setMeasurementEdge(measurementEdge);
        measurementTime.getMeasurementEdges().add(measurementEdge);

        return measurementLocation;
    }
}
