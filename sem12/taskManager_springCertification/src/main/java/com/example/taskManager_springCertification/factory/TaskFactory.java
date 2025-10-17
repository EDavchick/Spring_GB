package com.example.taskManager_springCertification.factory;

import com.example.taskManager_springCertification.model.Task;

public interface TaskFactory {
    Task createTask(String description);
}
