package com.example.taskManager_springCertification.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("URGENT")
@NoArgsConstructor
public class UrgentTask extends Task{
    public UrgentTask(String description) {
        super(null, description);
    }
}
