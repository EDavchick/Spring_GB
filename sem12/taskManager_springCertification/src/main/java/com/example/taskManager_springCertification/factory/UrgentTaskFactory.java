package com.example.taskManager_springCertification.factory;

import com.example.taskManager_springCertification.model.Task;
import com.example.taskManager_springCertification.model.UrgentTask;

public class UrgentTaskFactory implements TaskFactory{
    @Override
    public Task createTask(String description) {
        return new UrgentTask("URGENT!!! "
        + description);
    }
}
