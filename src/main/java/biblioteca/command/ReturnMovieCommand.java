package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.Movie;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;


public class ReturnMovieCommand implements Command {
    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {

        if (library.isLogged()) {
            output.print(ENTER__MOVIE_NAME_TO_RETURN);
            String inputString = input.readInputString();
            Movie movieToCheckout = new Movie(inputString, null, 1000, "10");

            if (library.returnItem(movieToCheckout)) {
                output.print(RETURN_MOVIE_SUCCESSFUL);
            } else {
                output.print(RETURN_MOVIE_UNSUCCESSFUL);
            }
        } else {
            output.print(NOT_LOGGED);
        }
    }
}
