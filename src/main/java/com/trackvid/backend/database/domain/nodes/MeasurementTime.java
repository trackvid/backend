package com.trackvid.backend.database.domain.nodes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.trackvid.backend.database.converters.LocalTimeConverter;
import com.trackvid.backend.database.domain.edges.MeasurementEdge;
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
import org.neo4j.ogm.annotation.typeconversion.Convert;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementTime {

    @Id
    @GeneratedValue
    private Long id;

    @Convert(LocalTimeConverter.class)
    private LocalTime time;

    @JsonManagedReference
    @NotNull
    @Relationship(type = MeasurementTimeEdge.RELATIONSHIP_TYPE, direction = Relationship.INCOMING)
    private MeasurementTimeEdge measurementTimeEdge;

    @JsonBackReference
    @Builder.Default
    @Relationship(type = MeasurementEdge.RELATIONSHIP_TYPE)
    private List<MeasurementEdge> measurementEdges = new ArrayList<>();
}
