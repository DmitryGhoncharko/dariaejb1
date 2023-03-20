package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.SimpleRequestFactory;
import by.webproj.carshowroom.exception.ServiceError;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShowLoginPageCommand implements Command{

    private final SimpleRequestFactory requestFactory;
    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError {
        return requestFactory.createForwardResponse(PagePath.LOGIN_PAGE.getPath());
    }
}
