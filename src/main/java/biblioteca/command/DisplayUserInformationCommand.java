package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

//Command to display logged user's information
public class DisplayUserInformationCommand implements Command {
    @Override
    public void perform(ConsoleOutputDriver outputDriver, InputDriver inputDriver, Library library) {
        outputDriver.print(library.currentUserInformation());
    }
}
