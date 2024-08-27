package com.run.gtask.mapper;

import com.run.gtask.dto.EstimatedTimeDTO;
import com.run.gtask.entity.EstimatedTime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstimatedTimeMapper {
    EstimatedTimeMapper INSTANCE = Mappers.getMapper(EstimatedTimeMapper.class);

    EstimatedTimeDTO toDTO(EstimatedTime estimatedTime);
    EstimatedTime toEntity(EstimatedTimeDTO estimatedTimeDTO);
}
