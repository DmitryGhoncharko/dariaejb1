package by.webproj.carshowroom.service;

import by.webproj.carshowroom.entity.Person;

public interface PersonService {
    boolean login(String login, String password);

    void logout();

    boolean registration(String name, String yearOfBirdth, String login, String password);

}
