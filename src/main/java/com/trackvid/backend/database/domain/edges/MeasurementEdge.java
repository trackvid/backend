package com.trackvid.backend.database.domain.edges;

import com.trackvid.backend.database.domain.nodes.MeasurementLocation;
import com.trackvid.backend.database.domain.nodes.MeasurementTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;


@RelationshipEntity(type = MeasurementEdge.RELATIONSHIP_TYPE)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementEdge {

    public static final String RELATIONSHIP_TYPE = "MEASUREMENT_LOCATION";

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private MeasurementTime measurementTime;

    @EndNode
    private MeasurementLocation measurementLocation;
}
