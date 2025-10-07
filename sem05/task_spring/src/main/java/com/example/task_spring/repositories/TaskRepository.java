package com.example.task_spring.repositories;

import com.example.task_spring.service.Task;
import com.example.task_spring.status.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
Repository for task entities
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Receives a task by status
     * @param status Task status
     * @return List of tasks with status
     */
    List<Task> findByStatus(TaskStatus status);
}

