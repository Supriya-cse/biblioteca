package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.SUCCESFUL_LOGOUT;
import static biblioteca.common.Constants.UNSUCCESFUL_LOGOUT;

public class LogOutCommand implements Command {
    @Override
    public void perform(ConsoleOutputDriver outputDriver, InputDriver inputDriver, Library library) {
        if (library.isCurrentUserLogged()) {
            if (!library.logout()) {
                outputDriver.print(UNSUCCESFUL_LOGOUT);
            }
        }
        outputDriver.print(SUCCESFUL_LOGOUT);
    }
}