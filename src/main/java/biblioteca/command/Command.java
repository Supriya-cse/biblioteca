package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

public interface Command {
    void perform(ConsoleOutputDriver outputDriver, InputDriver inputDriver, Library library);
}
