package com.example.taskManager_springCertification.observer;

import com.example.taskManager_springCertification.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskLogger implements TaskObserver{
    @Override
    public void update(Task task) {
        System.out.println("The new task is added: "
        + task.getDescription());
    }
}
