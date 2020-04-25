package com.trackvid.backend.database.domain.nodes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trackvid.backend.database.domain.edges.MeasurementTimeEdge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDay {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate dayDate;

    @JsonBackReference
    @Relationship(type = MeasurementTimeEdge.RELATIONSHIP_TYPE)
    @Builder.Default
    private List<MeasurementTimeEdge> measurementTimeEdges = new ArrayList<>();
}
