package ru.sergeypyzin.springwebfirstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeypyzin.springwebfirstproject.domain.User;
import ru.sergeypyzin.springwebfirstproject.services.DataProcessingService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final DataProcessingService service;

    public TaskController(DataProcessingService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }


    /**
     * Обрабатывает запрос на фильтрацию пользователей по возрасту.
     * Возвращает список пользователей, у которых возраст больше указанного.
     *
     * @param age возраст, по которому производится фильтрация
     * @return список пользователей, чей возраст больше указанного
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }


    /**
     * Обрабатывает запрос на расчет среднего возраста пользователей.
     * Вычисляет средний возраст всех пользователей из репозитория.
     *
     * @return средний возраст пользователей из репозитория
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
