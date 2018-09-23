package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

public class ReturnCommand implements Command {

    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        output.print(ENTER__BOOK_NAME_TO_RETURN);
        String inputString = input.readInputString();
        if (library.returnBook(inputString)) {
            output.print(RETURN_SUCCESSFUL);
        } else {
            output.print(RETURN_UNSUCCESSFUL);
        }
    }
}
