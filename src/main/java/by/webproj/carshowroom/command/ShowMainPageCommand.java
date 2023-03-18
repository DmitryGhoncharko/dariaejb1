package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.exception.ServiceError;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ShowMainPageCommand implements Command{
    @EJB
    private RequestFactory requestFactory;
    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError {
        return requestFactory.createForwardResponse(PagePath.LOGIN_PAGE.getPath());
    }
}
