package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.Movie;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.MOVIE_REPRESENTATION_FORMAT;

//Command to display list of movies from the library
public class ListMoviesCommand implements Command {
    @Override
    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        output.print(String.format(MOVIE_REPRESENTATION_FORMAT, "Title", "Director", "Year", "Rating"));
        for (String string : library.getListOfLibraryItems(Movie.class)) {
            output.print(string);
        }
    }
}