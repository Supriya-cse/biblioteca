package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

public class QuitCommand implements Command {
    @Override
    public void perform(ConsoleOutputDriver outputDriver, InputDriver inputDriver, Library library) {
        return;
    }
}
