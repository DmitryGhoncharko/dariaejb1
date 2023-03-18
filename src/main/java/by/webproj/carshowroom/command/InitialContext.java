package by.webproj.carshowroom.command;

import javax.ejb.Singleton;

@Singleton
public class InitialContext {
    public Command lookup(String commandName) {

        switch (commandName) {
            default:{
                return new ShowMainPageCommand();
            }
        }
    }
}
