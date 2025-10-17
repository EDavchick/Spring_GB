package com.example.taskManager_springCertification.factory;

import com.example.taskManager_springCertification.model.RegularTask;
import com.example.taskManager_springCertification.model.Task;

public class RegularTaskFactory implements TaskFactory{
    @Override
    public Task createTask(String description) {
        return new RegularTask("REGULAR "
        + description);
    }
}
