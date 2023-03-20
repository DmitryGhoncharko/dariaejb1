package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.SimpleRequestFactory;
import by.webproj.carshowroom.repository.PersonRepository;
import by.webproj.carshowroom.repository.SimplePersonRepository;
import by.webproj.carshowroom.repository.sessionfactory.HibernateSessionFactoryUtil;
import by.webproj.carshowroom.securiy.BcryptWithSaltHasherImpl;
import by.webproj.carshowroom.securiy.PasswordHasher;
import by.webproj.carshowroom.service.PersonService;
import by.webproj.carshowroom.service.SimplePersonService;
import by.webproj.carshowroom.validator.PersonValidator;

import javax.ejb.Singleton;

@Singleton
public class InitialContext {
    private final SimpleRequestFactory simpleRequestFactory = new SimpleRequestFactory();
    private final HibernateSessionFactoryUtil hibernateSessionFactoryUtil = new HibernateSessionFactoryUtil();
    private final PersonRepository personRepository = new SimplePersonRepository(hibernateSessionFactoryUtil);
    private final PasswordHasher passwordHasher = new BcryptWithSaltHasherImpl();
    private final PersonValidator personValidator = new PersonValidator();
    private final PersonService personService = new SimplePersonService(personValidator, passwordHasher, personRepository);

    public Command lookup(String commandName) {

        switch (commandName) {
            case "login": {
                return new ShowLoginPageCommand(simpleRequestFactory);
            }
            case "registration": {
                return new ShowRegistrationPageCommand(simpleRequestFactory);
            }
            case "logincmnd": {
                return new LoginCommand(simpleRequestFactory, personService);
            }
            case "registrationcmnd": {
                return new RegistrationCommand(simpleRequestFactory, personService);
            }
            case "logout": {
                return new LogoutCommand(simpleRequestFactory);
            }
            case "cab": {
                return new ShowCabinetPageCommand(simpleRequestFactory, personService);
            }
            case "error": {
                return new ShowErrorJspPage(simpleRequestFactory);
            }
            case "updatePerson": {
                return new UpdatePersonCommand(simpleRequestFactory, personService);
            }
            default: {
                return new ShowLoginPageCommand(simpleRequestFactory);
            }
        }
    }
}
