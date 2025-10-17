package com.example.taskManager_springCertification.observer;

import com.example.taskManager_springCertification.model.Task;

public interface TaskObserver {
    void update(Task task);
}
