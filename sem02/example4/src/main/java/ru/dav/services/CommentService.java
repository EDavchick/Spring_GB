package ru.dav.services;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentService {
    public CommentService() {
        System.out.println("Создан CommentService");
    }
}
