package com.trackvid.backend.api.controller;

import com.trackvid.backend.domain.FoundCases;
import com.trackvid.backend.domain.Measurements;
import com.trackvid.backend.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/measurements")
@RestController
@RequiredArgsConstructor
public class MeasurementController {
    private final MeasurementService measurementService;

    @PostMapping
    public void addMeasurements(@RequestBody final Measurements measurements) {
        measurementService.addMeasurements(measurements);
    }

    @PutMapping("/check")
    public FoundCases checkMyPath(@RequestBody final Measurements measurements) {
        return FoundCases.builder()
                .foundCaseList(measurementService.getAllCasesNearMeasurements(measurements))
                .build();
    }
}
