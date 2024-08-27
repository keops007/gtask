package com.run.gtask.mapper;

import com.run.gtask.dto.EstimatedTimeDTO;
import com.run.gtask.entity.EstimatedTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-22T14:52:48+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class EstimatedTimeMapperImpl implements EstimatedTimeMapper {

    @Override
    public EstimatedTimeDTO toDTO(EstimatedTime estimatedTime) {
        if ( estimatedTime == null ) {
            return null;
        }

        EstimatedTimeDTO estimatedTimeDTO = new EstimatedTimeDTO();

        estimatedTimeDTO.setId( estimatedTime.getId() );
        estimatedTimeDTO.setDescription( estimatedTime.getDescription() );
        estimatedTimeDTO.setHours( estimatedTime.getHours() );

        return estimatedTimeDTO;
    }

    @Override
    public EstimatedTime toEntity(EstimatedTimeDTO estimatedTimeDTO) {
        if ( estimatedTimeDTO == null ) {
            return null;
        }

        EstimatedTime estimatedTime = new EstimatedTime();

        estimatedTime.setId( estimatedTimeDTO.getId() );
        estimatedTime.setDescription( estimatedTimeDTO.getDescription() );
        estimatedTime.setHours( estimatedTimeDTO.getHours() );

        return estimatedTime;
    }
}
