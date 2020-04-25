package com.trackvid.backend.database.domain.nodes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trackvid.backend.database.domain.edges.MeasurementEdge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.validation.constraints.NotNull;

@NodeEntity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementLocation {

    @Id
    @GeneratedValue
    private Long id;

    private double longitude;
    private double latitude;

    @JsonManagedReference
    @NotNull
    @Relationship(type = MeasurementEdge.RELATIONSHIP_TYPE, direction = Relationship.INCOMING)
    private MeasurementEdge measurementEdge;
}
