package com.example.task_spring.controller;

import com.example.task_spring.repositories.TaskRepository;
import com.example.task_spring.service.Task;
import com.example.task_spring.status.TaskStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller for manage tasks
 */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;

    /**
     * Add a new task
     * @param task New task
     * @return added task
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setCreationDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    /**
     * Receiving all tasks
     * @return List of tasks
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Receiving task by status
     * @param taskStatus Task status
     * @return List of tasks whit status
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus taskStatus) {
        return taskRepository.findByStatus(taskStatus);
    }

    /**
     * Update status of task
     * @param id Identification tasks for update
     * @param task Updated task
     * @return Updated task
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setStatus(task.getStatus());
            return taskRepository.save(existingTask);
        } else return null;
    }

    /**
     * Delete task by ID
     * @param id ID task for deleted
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
