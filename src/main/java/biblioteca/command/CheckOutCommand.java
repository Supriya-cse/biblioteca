package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

public class CheckOutCommand implements Command {

    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        output.print(ENTER_BOOK_NAME_TO_CHECK_OUT);
        String inputString = input.readInputString();
        if (!library.checkOut(inputString)) {
            output.print(BOOK_NOT_AVAILABLE);
        } else {
            output.print(SUCCESSFUL_CHECKOUT);
        }
    }
}
