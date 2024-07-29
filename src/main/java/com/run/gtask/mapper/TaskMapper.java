package com.run.gtask.mapper;

import com.run.gtask.dto.TaskDTO;
import com.run.gtask.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO toDto(Task task);
    Task toEntity(TaskDTO taskDTO);
}
