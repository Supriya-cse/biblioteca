package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.INVALID_OPTION_MESSAGE;

//Command to display message if invalid option is selected
public class InvalidCommand implements Command {
    @Override
    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        output.print(INVALID_OPTION_MESSAGE);
    }
}
