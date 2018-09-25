package biblioteca.command;

import biblioteca.model.Librarian;
import biblioteca.model.Library;
import biblioteca.model.LibraryHelper;
import biblioteca.model.Movie;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static biblioteca.common.Constants.RETURN_MOVIE_SUCCESSFUL;
import static biblioteca.common.Constants.RETURN_MOVIE_UNSUCCESSFUL;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ReturnMovieCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private ReturnMovieCommand returnMovieCommand;
    private LibraryHelper libraryHelper;
    private Librarian librarian;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        librarian = Mockito.mock(Librarian.class);
        libraryHelper = new LibraryHelper();
        library = new Library(libraryHelper.listOfLibraryItems(), libraryHelper.listOfUser());
        library.authenticate("222-3232", "supriya7");

    }

    @DisplayName("should return a movie that is present in the moviecheckedout list of the library")
    @Test
    void testForReturningMovieThatExistsInLibrary() {
        when(input.readInputString()).thenReturn("Hachiko");
        library.checkOutItem(new Movie("Hachiko", null, 1000, "9"));
        returnMovieCommand = new ReturnMovieCommand();
        returnMovieCommand.perform(output, input, library);
        assertTrue(library.returnItem(new Movie("Hachiko", null, 1000, "9")));
    }

    @DisplayName("should display succesful message when book is returned successfully")
    @Test
    void testForDisplayingSuccessMessage() {
        when(input.readInputString()).thenReturn("Hachiko");
        library.checkOutItem(new Movie("Hachiko", null, 1000, "9"));
        returnMovieCommand = new ReturnMovieCommand();
        returnMovieCommand.perform(output, input, library);
        Mockito.verify(output).print(RETURN_MOVIE_SUCCESSFUL);
    }

    @DisplayName("should display unsuccesful message when book is returned successfully")
    @Test
    void testForDisplayingUnSuccessMessage() {
        when(input.readInputString()).thenReturn("Hachiko");
        library.checkOutItem(new Movie("Hachi", null, 1000, "9"));
        returnMovieCommand = new ReturnMovieCommand();
        returnMovieCommand.perform(output, input, library);
        Mockito.verify(output).print(RETURN_MOVIE_UNSUCCESSFUL);
    }
}
