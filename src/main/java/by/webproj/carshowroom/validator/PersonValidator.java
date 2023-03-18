package by.webproj.carshowroom.validator;

import javax.ejb.Singleton;

@Singleton
public class PersonValidator {
    public boolean validate(String login, String password) {
        return login != null || password != null;
    }
}
