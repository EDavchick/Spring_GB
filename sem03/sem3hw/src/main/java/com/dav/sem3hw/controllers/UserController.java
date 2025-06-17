package com.dav.sem3hw.controllers;

import com.dav.sem3hw.domain.User;
import com.dav.sem3hw.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

    @Autowired
    private RegistrationService service;

    /**
     * Getting list users
     * @return JSON response with list of users
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Add new user
     * @param requestBody body request
     * @return notification added user
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        Integer age = (Integer) requestBody.get("age");
        String email = (String) requestBody.get("email");
        service.processRegistration(name, age, email);
        return "User added from body";
    }

    /*
    In Postman:

    POST -> http://localhost:8080/users/body -> Body -> raw JSON
    {
    "name": "Bob",
    "age": 29,
    "email": "1234@rty.com"
    }
    -> SEND -> User added from body

=================
    GET -> http://localhost:8080/users -> SEND

    [
    {
        "name": "Bob",
        "age": 29,
        "email": "1234@rty.com"
    },
    {
        "name": "Mike",
        "age": 45,
        "email": "345@rty.com"
    },
    {
        "name": "Samanta",
        "age": 39,
        "email": "dfgh@rty.com"
    }
    ]
     */
}
