package com.trackvid.backend.database.domain.edges;

import com.trackvid.backend.database.domain.nodes.MeasurementDay;
import com.trackvid.backend.database.domain.nodes.MeasurementTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = MeasurementTimeEdge.RELATIONSHIP_TYPE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementTimeEdge {

    public static final String RELATIONSHIP_TYPE = "TIME_OF_MEASUREMENT";

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private MeasurementDay measurementDay;

    @EndNode
    private MeasurementTime measurementTime;
}
