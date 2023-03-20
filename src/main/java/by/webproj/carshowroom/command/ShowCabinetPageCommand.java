package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.entity.Person;
import by.webproj.carshowroom.exception.ServiceError;
import by.webproj.carshowroom.service.PersonService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ShowCabinetPageCommand implements Command {
    private final RequestFactory requestFactory;
    private final PersonService personService;
    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError {
        if (request.sessionExists() && request.retrieveFromSession("person").isPresent()) {
            Person person =(Person)request.retrieveFromSession("person").get();
            Optional<Person> personOptional = personService.getByLogin(person.getLogin());
            if(personOptional.isPresent()){
                request.addAttributeToJsp("person",personOptional.get());
            }
            return requestFactory.createForwardResponse(PagePath.CABINET_PAGE.getPath());
        }
        return requestFactory.createRedirectResponse("/carshowroom-1.0-SNAPSHOT/controller?command=login");
    }
}
