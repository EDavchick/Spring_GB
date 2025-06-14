package com.dav.sem3hw.services;

import com.dav.sem3hw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    // с аннотацией @Autowired конструктор не нужно создавать, он его сам автоматом создаст
    private NotificationService notificationService;


    // Внедрение зависимости через конструктор
//    public UserService(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }

    // создает пользователя и возвращает его
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

    // Отправляем уведомление о создании нового пользователя
         notificationService.notifyUser(user);
         return user;
    }

}
