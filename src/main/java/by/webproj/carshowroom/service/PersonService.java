package by.webproj.carshowroom.service;

import by.webproj.carshowroom.entity.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> login(String login, String password);

    boolean registration(String name, String yearOfBirdth, String login, String password);


    Optional<Person> getByLogin(String login);

    void update(String name, String yearOfBirdth, String id, String login, String password);
}
