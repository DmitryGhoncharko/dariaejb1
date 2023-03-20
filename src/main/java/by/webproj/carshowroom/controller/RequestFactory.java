package by.webproj.carshowroom.controller;

import by.webproj.carshowroom.command.CommandRequest;
import by.webproj.carshowroom.command.CommandResponse;


import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
@Local
public interface RequestFactory {

    CommandRequest createRequest(HttpServletRequest request);

    CommandResponse createForwardResponse(String path);

    CommandResponse createRedirectResponse(String path);

}
