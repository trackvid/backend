package com.trackvid.backend.database.repository;

import com.trackvid.backend.database.domain.nodes.MeasurementTime;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementTimeRepository extends Neo4jRepository<MeasurementTime, Long> {
    Optional<MeasurementTime> findByTimeAndAndMeasurementTimeEdge_MeasurementDay_DayDate(LocalTime time, LocalDate dayDate);

    List<MeasurementTime> findAllByTimeBetweenAndAndMeasurementTimeEdge_MeasurementDay_DayDate(LocalTime minTime, LocalTime maxTime, LocalDate dayDate);
}
