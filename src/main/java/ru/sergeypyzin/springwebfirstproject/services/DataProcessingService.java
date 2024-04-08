package ru.sergeypyzin.springwebfirstproject.services;

import org.springframework.stereotype.Service;
import ru.sergeypyzin.springwebfirstproject.domain.User;
import ru.sergeypyzin.springwebfirstproject.repository.UserRepository;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    private final UserRepository repository;

    public DataProcessingService(UserRepository repository) {
        this.repository = repository;
    }

    public UserRepository getRepository() {
        return repository;
    }

    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }

    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        if (users.isEmpty()){
            return 0;
        } else {
            return users.stream()
                    .mapToInt(User::getAge)
                    .average()
                    .orElse(0);
        }
    }

}
