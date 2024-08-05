package com.run.gtask.mapper;

import com.run.gtask.dto.TaskDTO;
import com.run.gtask.entity.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T12:50:59+0300",
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

        return task;
    }
}
