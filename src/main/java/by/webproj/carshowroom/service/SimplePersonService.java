package by.webproj.carshowroom.service;

import by.webproj.carshowroom.entity.Person;
import by.webproj.carshowroom.exception.RepositoryException;
import by.webproj.carshowroom.exception.ServiceError;
import by.webproj.carshowroom.repository.PersonRepository;
import by.webproj.carshowroom.securiy.PasswordHasher;
import by.webproj.carshowroom.validator.PersonValidator;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.EJB;
import java.util.Optional;

@Slf4j
public class SimplePersonService implements PersonService{
    @EJB
    private  PersonValidator personValidator;
    @EJB
    private PasswordHasher passwordHasher;
    @EJB
    private PersonRepository personRepository;

    @Override
    public boolean login(String login, String password) {
        if(!personValidator.validate(login,password)){
            log.error("invalid user login and password, cannot login");
            return false;
        }
        try{
            Optional<Person> personOptional = personRepository.getByLogin(login);
            if(personOptional.isPresent()){
                Person person = personOptional.get();
                String hashedPassword = passwordHasher.hashPassword(password);
                return passwordHasher.checkIsEqualsPasswordAndPasswordHash(person.getPassword(),hashedPassword);
            }
        }catch (RepositoryException e){
            log.error("Cannot login user",e);
            throw new ServiceError("Cannot login user",e);
        }
        log.error("Cannot login user");
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public boolean registration(String name, String yearOfBirdth, String login, String password) {
        return false;
    }
}
