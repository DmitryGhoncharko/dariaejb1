package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.exception.ServiceError;
import by.webproj.carshowroom.service.PersonService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdatePersonCommand implements Command{
    private final RequestFactory requestFactory;
    private final PersonService personService;
    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError {
        String name = request.getParameter("name");
        String year = request.getParameter("year");
        String id = request.getParameter("id");
        String login = request.getParameter("login");
        String password  = request.getParameter("password");
        personService.update(name,year,id, login, password);
        return requestFactory.createRedirectResponse("/carshowroom-1.0-SNAPSHOT/controller?command=cab");
    }
}
