package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.Movie;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

public class CheckOutMovieCommand implements Command {

    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        if (library.isCurrentUserLogged()) {
            output.print(ENTER_MOVIE_NAME_TO_CHECK_OUT);
            String inputString = input.readInputString();
            Movie movieToCheckout = new Movie(inputString, null, 1000, "10");

            if (!library.checkOutItem(movieToCheckout)) {
                output.print(MOVIE_NOT_AVAILABLE);
            } else {
                output.print(SUCCESSFUL_CHECKOUT_OF_MOVIE);
            }
        } else {
            output.print(NOT_LOGGED);
        }
    }
}