package ru.sergeypyzin.springwebfirstproject.services;


import org.springframework.stereotype.Service;
import ru.sergeypyzin.springwebfirstproject.domain.User;


@Service
public class UserService {

    private final NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

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
