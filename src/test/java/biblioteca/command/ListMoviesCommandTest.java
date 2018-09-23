package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.Movie;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static biblioteca.common.Constants.MOVIE_REPRESENTATION_FORMAT;
import static org.mockito.Mockito.when;

public class ListMoviesCommandTest {
    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private ListMoviesCommand listMoviesCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);
        ArrayList<String> movies = new ArrayList<>();
        movies.add(String.format(MOVIE_REPRESENTATION_FORMAT, "Kushi", "sj suriya", 1997, 9));
        movies.add(String.format(MOVIE_REPRESENTATION_FORMAT, "Steve", "Larsen", 1998, 8));
        when(library.getListOfLibraryItems(Movie.class)).thenReturn(movies);
        listMoviesCommand = new ListMoviesCommand();
        listMoviesCommand.perform(output, input, library);
    }

    @DisplayName("should display header for list of books")
    @Test
    void testForHeaderOfListOfBooks() {
        Mockito.verify(output).print(String.format(MOVIE_REPRESENTATION_FORMAT, "Title", "Director", "Year", "Rating"));
    }


    @DisplayName("Should display no books available if there are no books in library")
    @Test
    void testForDisplayingBooksAvailable() {

        Mockito.verify(output).print(String.format(MOVIE_REPRESENTATION_FORMAT, "Kushi", "sj suriya", 1997, 9));
        Mockito.verify(output).print(String.format(MOVIE_REPRESENTATION_FORMAT, "Steve", "Larsen", 1998, 8));
    }

}

