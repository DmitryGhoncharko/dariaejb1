package by.webproj.carshowroom.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final String commandName = req.getParameter("command");
        if (currentUserHasPermissionForCommand(commandName, req)) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/carshowroom-1.0-SNAPSHOT/controller?command=error");
        }
    }

    private boolean currentUserHasPermissionForCommand(String commandName, HttpServletRequest request) {
        return definePermissionForCommand(sessionIsExist(request),commandName);
    }

    private boolean sessionIsExist(HttpServletRequest request) {
        return request.getSession(false)!=null && request.getSession(false).getAttribute("person")!=null;
    }

    private boolean definePermissionForCommand(boolean sessionIsExist, String commandName) {
        if(sessionIsExist){
            return commandName == null || (!commandName.equals("login") && !commandName.equals("logincmnd"));
        }else {
            return commandName == null || (commandName.equals("login") || commandName.equals("logincmnd") || (commandName.equals("registration") || commandName.equals("registrationcmnd") || commandName.equals("error")));
        }
    }
}