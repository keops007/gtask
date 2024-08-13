package com.run.gtask.service;

import com.run.gtask.dto.CommentDTO;
import com.run.gtask.entity.Comment;
import com.run.gtask.mapper.CommentMapper;
import com.run.gtask.repository.CommentRepository;
import com.run.gtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CommentMapper commentMapper;

    public CommentDTO addCommentToTask(Long taskId, CommentDTO commentDTO) {
        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setTask(taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found")));
        return commentMapper.toDto(commentRepository.save(comment));
    }

    public List<CommentDTO> getCommentsForTask(Long taskId) {
        return commentRepository.findByTaskId(taskId).stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }
}
