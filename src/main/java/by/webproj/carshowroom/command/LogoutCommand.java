package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.exception.ServiceError;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogoutCommand implements Command{
    private final RequestFactory requestFactory;

    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError {
        if(request.sessionExists()){
            request.clearSession();
        }
        return requestFactory.createRedirectResponse("/carshowroom-1.0-SNAPSHOT/controller?command=login");
    }
}
