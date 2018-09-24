package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

//Command to login in to Biblioteca Application
public class LoginCommand implements Command {
    @Override
    public void perform(ConsoleOutputDriver outputDriver, InputDriver inputDriver, Library library) {
        outputDriver.print(ENTER_LIBRARY_NUMBER);
        String libraryNo = inputDriver.readInputString();
        outputDriver.print(ENTER_PASSWORD);
        String password = inputDriver.readInputString();

        if (!library.authenticate(libraryNo, password)) {
            outputDriver.print(LOGIN_UNSUCCESSFUL);
        } else {
            outputDriver.print(LOGIN_SUCCESSFUL);
        }
    }
}
