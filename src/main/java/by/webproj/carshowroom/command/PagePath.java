package by.webproj.carshowroom.command;

public enum PagePath {
    LOGIN_PAGE("/WEB-INF/jsp/login.jsp");

    final String path;
    PagePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
