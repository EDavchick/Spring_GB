package com.example.taskManager_springCertification.controller;

import com.example.taskManager_springCertification.dto.TaskDescriptionDTO;
import com.example.taskManager_springCertification.factory.RegularTaskFactory;
import com.example.taskManager_springCertification.factory.UrgentTaskFactory;
import com.example.taskManager_springCertification.model.Task;
import com.example.taskManager_springCertification.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/urgent")
    public Task createUrgentTask(@RequestBody TaskDescriptionDTO request) {
        UrgentTaskFactory factory = new UrgentTaskFactory();
        Task task = factory.createTask(request.getDescription());
        return taskService.addTask(task);
    }

    @PostMapping("/regular")
    public Task createRegularTask(@RequestBody TaskDescriptionDTO request) {
        RegularTaskFactory factory = new RegularTaskFactory();
        Task task = factory.createTask(request.getDescription());
        return taskService.addTask(task);
    }
}
