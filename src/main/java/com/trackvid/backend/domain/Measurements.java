package com.trackvid.backend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class Measurements {
    private Collection<Measurement> measurements;
}
