package com.run.gtask.controller;

import com.run.gtask.dto.CommentDTO;
import com.run.gtask.dto.TaskDTO;
import com.run.gtask.entity.Task;
import com.run.gtask.entity.User;
import com.run.gtask.repository.TaskRepository;
import com.run.gtask.repository.UserRepository;
import com.run.gtask.service.CommentService;
import com.run.gtask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(taskDTO);

        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(id, taskDTO);
    }

    @GetMapping("{id}")
    public TaskDTO getTashById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("{id}")
    public void deleteTask(Long id) {
        taskService.deleteTask(id);
    }

    // Endpoint pentru asignarea unui task unui utilizator
    @PostMapping("/{taskId}/assign/{userId}")
    public ResponseEntity<String> assignTaskToUser(@PathVariable Long taskId, @PathVariable Long userId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setUser(user); // Asignarea utilizatorului la task
        taskRepository.save(task); // Salvează task-ul updatat

        return ResponseEntity.ok("Task assigned to user");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskDTO>> getTasksByUserId(@PathVariable Long userId) {
        List<TaskDTO> tasks = taskService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/{taskId}/comments")
    public ResponseEntity<CommentDTO> addComment(@PathVariable Long taskId, @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.addCommentToTask(taskId, commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}/comments")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable Long taskId) {
        return new ResponseEntity<>(commentService.getCommentsForTask(taskId), HttpStatus.OK);
    }

    @PutMapping("/{taskId}/estimated-time/{estimatedTimeId}")
    public ResponseEntity<TaskDTO> associateEstimatedTime(
            @PathVariable Long taskId,
            @PathVariable Long estimatedTimeId) {
        TaskDTO updatedTask = taskService.associateEstimatedTime(taskId, estimatedTimeId);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}
