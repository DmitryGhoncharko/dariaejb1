package by.webproj.carshowroom.validator;

import javax.ejb.Singleton;

@Singleton
public class PersonValidator {
    public boolean validate(String login, String password) {
        return login != null || password != null;
    }
    public boolean validate(String password) {
        return password != null;
    }

    public boolean validate(String name, String yearOfBirdth, String password) {
        return name != null || password != null || yearOfBirdth != null;
    }
}
