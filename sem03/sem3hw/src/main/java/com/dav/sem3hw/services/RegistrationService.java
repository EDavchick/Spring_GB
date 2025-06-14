package com.dav.sem3hw.services;

import com.dav.sem3hw.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserService userService;
    private final DataProcessingService dataProcessingService;
    private final NotificationService notificationService;


    /**
     * Constructor of RegistrationService class
     * @param dataProcessingService сервис для работы с хранилищем пользователей
     * @param userService сервис создания пользователей
     * @param notificationService сервис консольных уведомлений
     */
    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }

    /**
     * Получение сервиса работы с хранилищем пользователей
     * @return
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    /**
     * Save user in DB, method implements in UserController class
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email имейл пользователя
     */
    public void processRegistration(String name, int age, String email){
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(createUser);
        notificationService.notifyUser(createUser);
    }
}
