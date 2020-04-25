package com.trackvid.backend.database.repository;

import com.trackvid.backend.database.domain.nodes.MeasurementDay;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MeasurementDayRepository extends Neo4jRepository<MeasurementDay, Long> {
    Optional<MeasurementDay> findByDayDate(LocalDate measurementDay);
}
