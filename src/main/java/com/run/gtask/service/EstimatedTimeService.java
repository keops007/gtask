package com.run.gtask.service;

import com.run.gtask.dto.EstimatedTimeDTO;
import com.run.gtask.entity.EstimatedTime;
import com.run.gtask.mapper.EstimatedTimeMapper;
import com.run.gtask.repository.EstimatedTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimatedTimeService {

    @Autowired
    private EstimatedTimeRepository estimatedTimeRepository;

    public EstimatedTimeDTO createEstimatedTime(EstimatedTimeDTO estimatedTimeDTO) {
        EstimatedTime estimatedTime = EstimatedTimeMapper.INSTANCE.toEntity(estimatedTimeDTO);
        estimatedTime = estimatedTimeRepository.save(estimatedTime);
        return EstimatedTimeMapper.INSTANCE.toDTO(estimatedTime);
    }

    public List<EstimatedTimeDTO> getAllEstimatedTimes() {
        return estimatedTimeRepository.findAll().stream()
                .map(EstimatedTimeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
