package biblioteca.command;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

//Command to checkoutBook from library
public class CheckOutBookCommand implements Command {
    @Override
    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        if (library.isCurrentUserLogged()) {
            output.print(ENTER_BOOK_NAME_TO_CHECK_OUT);
            String inputString = input.readInputString();
            Book bookToCheckout = new Book(inputString, null, 1);

            if (!library.checkOutItem(bookToCheckout)) {
                output.print(BOOK_NOT_AVAILABLE);
            } else {
                output.print(SUCCESSFUL_CHECKOUT);
            }
        } else {
            output.print(NOT_LOGGED);
        }
    }
}
