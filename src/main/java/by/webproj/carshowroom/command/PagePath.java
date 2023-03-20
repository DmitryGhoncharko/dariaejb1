package by.webproj.carshowroom.command;

public enum PagePath {
    LOGIN_PAGE("/WEB-INF/jsp/login.jsp"), REGISTRATION_PAGE("/WEB-INF/jsp/registration.jsp"), CABINET_PAGE("/WEB-INF/jsp/cab.jsp"), ERROR_JSP_PAGE("/WEB-INF/jsp/error.jsp");

    private final String path;
    PagePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
