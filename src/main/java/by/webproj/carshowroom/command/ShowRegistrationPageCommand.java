package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.exception.ServiceError;
import by.webproj.carshowroom.repository.PersonRepository;
import by.webproj.carshowroom.service.PersonService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShowRegistrationPageCommand implements Command{
    private final RequestFactory requestFactory;

    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError {

        return requestFactory.createForwardResponse(PagePath.REGISTRATION_PAGE.getPath());
    }
}
