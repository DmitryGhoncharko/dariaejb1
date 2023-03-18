package by.webproj.carshowroom.controller;

import by.webproj.carshowroom.command.CommandRequest;
import by.webproj.carshowroom.command.CommandResponse;


import javax.ejb.Singleton;
import javax.servlet.http.HttpServletRequest;
@Singleton
public class SimpleRequestFactory implements RequestFactory {

    @Override
    public CommandRequest createRequest(HttpServletRequest request) {
        return new WrappingCommandRequest(request);
    }

    @Override
    public CommandResponse createForwardResponse(String path) {
        return new PlainCommandResponse(path);
    }

    @Override
    public CommandResponse createRedirectResponse(String path) {
        return new PlainCommandResponse(true,path);
    }
}
