package ru.sergeypyzin.springwebfirstproject.controllers;


import org.springframework.web.bind.annotation.*;
import ru.sergeypyzin.springwebfirstproject.domain.User;
import ru.sergeypyzin.springwebfirstproject.services.RegistrationService;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RegistrationService service;

    public UserController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }


    /**
     * Обрабатывает запрос на добавление нового пользователя на основе параметров HTTP запроса.
     * Создает нового пользователя на основе переданных параметров и добавляет его в репозиторий.
     *
     * @param name  имя пользователя
     * @param age   возраст пользователя
     * @param email email пользователя
     * @return сообщение об успешном добавлении пользователя
     */
    @PostMapping()
    public String userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email) {

        service.processRegistration(name, age, email);
        return "User added from parameters!";
    }


}
