package com.run.gtask.controller;

import com.run.gtask.dto.EstimatedTimeDTO;
import com.run.gtask.service.EstimatedTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estimated-times")
public class EstimatedTimeController {

    @Autowired
    private EstimatedTimeService estimatedTimeService;

    @PostMapping
    public ResponseEntity<EstimatedTimeDTO> createEstimatedTime(@RequestBody EstimatedTimeDTO estimatedTimeDTO) {
        EstimatedTimeDTO createdEstimatedTime = estimatedTimeService.createEstimatedTime(estimatedTimeDTO);
        return new ResponseEntity<>(createdEstimatedTime, HttpStatus.CREATED);
    }

    @GetMapping
    public List<EstimatedTimeDTO> getAllEstimatedTimes() {
        return estimatedTimeService.getAllEstimatedTimes();
    }
}
