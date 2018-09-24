package biblioteca.command;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

public class ReturnBookCommand implements Command {

    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        if (library.isLogged()) {
            output.print(ENTER__BOOK_NAME_TO_RETURN);
            String inputString = input.readInputString();
            Book bookToCheckout = new Book(inputString, null, 1);

            if (library.returnItem(bookToCheckout)) {
                output.print(RETURN_SUCCESSFUL);
            } else {
                output.print(RETURN_UNSUCCESSFUL);
            }
        } else {
            output.print(NOT_LOGGED);
        }
    }
}
