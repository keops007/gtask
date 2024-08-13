package com.run.gtask.mapper;

import com.run.gtask.dto.CommentDTO;
import com.run.gtask.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO toDto(Comment comment);
    Comment toEntity(CommentDTO commentDTO);
}
