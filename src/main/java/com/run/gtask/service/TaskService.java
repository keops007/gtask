package com.run.gtask.service;

import com.run.gtask.dto.TaskDTO;
import com.run.gtask.entity.Task;
import com.run.gtask.mapper.TaskMapper;
import com.run.gtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        System.out.println(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setCompleted(taskDTO.getCompleted());
            taskRepository.save(task);
            return taskMapper.toDto(task);
        }

        // Returnează null dacă task-ul nu este găsit
        return null;
    }

    public TaskDTO getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto)
                .orElse(null); // Returnează null dacă task-ul nu este găsit
    }

    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
        // Nu aruncăm excepție, dar putem adăuga un log aici dacă este necesar
    }

    public List<TaskDTO> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId).stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }
}
