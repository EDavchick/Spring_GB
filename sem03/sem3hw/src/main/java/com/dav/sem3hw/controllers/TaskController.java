package com.dav.sem3hw.controllers;

import com.dav.sem3hw.domain.User;
import com.dav.sem3hw.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks") // localhost:8080/tasks
public class TaskController {

    /**
     * Service of processing tasks
     */
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Getting sorted list of users by age
     * @return JSON response with sorted list of users
     */
    @GetMapping("/sort") // localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Getting list of users older middle age
     * @param age возраст пользователей
     * @return JSON response with list of users
     */
    @GetMapping("/filter/{age}") // localhost:8080/tasks/filter/35
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Getting average age of users
     * @return JSON response with average age in double
     */
    @GetMapping("/calc") // localhost:8080/tasks/calc
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }

}
