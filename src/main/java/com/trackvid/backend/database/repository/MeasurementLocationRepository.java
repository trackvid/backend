package com.trackvid.backend.database.repository;

import com.trackvid.backend.database.domain.nodes.MeasurementLocation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementLocationRepository extends Neo4jRepository<MeasurementLocation, Long> {
    List<MeasurementLocation> findAllByLatitudeBetweenAndAndLongitudeBetweenAndMeasurementEdge_MeasurementTime_Id(
            double latitudeMin, double latitudeMax, double longitudeMin, double longitudeMax, long measurementTimeId
    );
}
