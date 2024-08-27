package com.run.gtask.mapper;

import com.run.gtask.dto.EstimatedTimeDTO;
import com.run.gtask.dto.TaskDTO;
import com.run.gtask.entity.EstimatedTime;
import com.run.gtask.entity.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-22T14:52:48+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO toDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId( task.getId() );
        taskDTO.setDescription( task.getDescription() );
        taskDTO.setTitle( task.getTitle() );
        taskDTO.setCompleted( task.getCompleted() );
        taskDTO.setEstimatedTime( estimatedTimeToEstimatedTimeDTO( task.getEstimatedTime() ) );

        return taskDTO;
    }

    @Override
    public Task toEntity(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskDTO.getId() );
        task.setTitle( taskDTO.getTitle() );
        task.setDescription( taskDTO.getDescription() );
        task.setCompleted( taskDTO.getCompleted() );
        task.setEstimatedTime( estimatedTimeDTOToEstimatedTime( taskDTO.getEstimatedTime() ) );

        return task;
    }

    protected EstimatedTimeDTO estimatedTimeToEstimatedTimeDTO(EstimatedTime estimatedTime) {
        if ( estimatedTime == null ) {
            return null;
        }

        EstimatedTimeDTO estimatedTimeDTO = new EstimatedTimeDTO();

        estimatedTimeDTO.setId( estimatedTime.getId() );
        estimatedTimeDTO.setDescription( estimatedTime.getDescription() );
        estimatedTimeDTO.setHours( estimatedTime.getHours() );

        return estimatedTimeDTO;
    }

    protected EstimatedTime estimatedTimeDTOToEstimatedTime(EstimatedTimeDTO estimatedTimeDTO) {
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
