package com.example.taskManager_springCertification.service;

import com.example.taskManager_springCertification.model.Task;
import com.example.taskManager_springCertification.observer.TaskObserver;
import com.example.taskManager_springCertification.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private static TaskService taskService;

    private final List<TaskObserver> observers = new ArrayList<>();

    @Autowired
    private TaskRepository taskRepository;

    private TaskService() {}

    public static TaskService getInstance() {
        if (taskService == null) {
            taskService = new TaskService();
        }
        return taskService;
    }

    public void addObserved(TaskObserver observer) {
        observers.add(observer);
    }

    public Task addTask(Task task) {
        Task saved = taskRepository.save(task);
        notifyObserved(saved);
        return saved;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    private void notifyObserved(Task task){
        for (TaskObserver observer : observers) {
            observer.update(task);
        }
    }
}
