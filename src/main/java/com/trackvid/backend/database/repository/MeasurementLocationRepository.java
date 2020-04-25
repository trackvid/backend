package com.trackvid.backend.database.repository;

import com.trackvid.backend.database.domain.nodes.MeasurementLocation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementLocationRepository extends Neo4jRepository<MeasurementLocation, Long> {
}
