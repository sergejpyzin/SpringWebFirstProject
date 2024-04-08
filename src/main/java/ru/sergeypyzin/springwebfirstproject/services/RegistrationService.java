package ru.sergeypyzin.springwebfirstproject.services;

import org.springframework.stereotype.Service;
import ru.sergeypyzin.springwebfirstproject.domain.User;


@Service
public class RegistrationService {
    private final DataProcessingService dataProcessingService;

    private final UserService userService;

    private final NotificationService notificationService;


    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }




    /**
     * Метод для регистрации нового пользователя.
     *
     * @param name  имя пользователя
     * @param age   возраст пользователя
     * @param email email пользователя
     */
    public void processRegistration(String name, int age, String email) {
        // Создание нового пользователя
        User newUser = userService.createUser(name, age, email);

        // Добавление пользователя в репозиторий
        dataProcessingService.addUserToList(newUser);

        // Вывод сообщения о регистрации пользователя
        notificationService.sendNotification("Пользователь " + newUser.getName() + " успешно зарегистрирован!");
    }
}
