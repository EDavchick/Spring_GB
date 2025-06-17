package com.dav.sem3hw.services;

import com.dav.sem3hw.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    /**
     * Печатает сообщение о том, что пользователь был создан
     * @param user
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created in DB: " + user.getName());
    }

}
