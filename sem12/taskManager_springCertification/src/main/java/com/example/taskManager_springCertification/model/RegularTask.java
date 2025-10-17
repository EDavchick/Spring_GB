package com.example.taskManager_springCertification.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("REGULAR")
@NoArgsConstructor
public class RegularTask extends Task{
    public RegularTask(String description) {
        super(null, description);
    }
}
