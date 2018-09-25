package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.LibraryHelper;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static biblioteca.common.Constants.SUCCESSFUL_CHECKOUT_OF_MOVIE;
import static org.mockito.Mockito.when;

public class CheckOutMovieCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private CheckOutMovieCommand checkOutMovieCommand;
    private LibraryHelper libraryHelper;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        libraryHelper = new LibraryHelper();
    }

    @DisplayName("should checkout a movie that is present in the movie list of the library")
    @Test
    void testForCheckingMovieThatExistsInLibrary() {
        library = new Library(libraryHelper.listOfLibraryItems(), libraryHelper.listOfUser());
        library.authenticate("222-3232", "supriya7");
        when(input.readInputString()).thenReturn("Hachiko");
        checkOutMovieCommand = new CheckOutMovieCommand();
        checkOutMovieCommand.perform(output, input, library);
        Mockito.verify(output).print(SUCCESSFUL_CHECKOUT_OF_MOVIE);
    }

    @DisplayName("should return unsuccessful mesage when checkout movie")
    @Test
    void testForCheckingOutUnSuccessfulMessage() {
        library = new Library(libraryHelper.listOfLibraryItems(), libraryHelper.listOfUser());
        library.authenticate("222-3232", "supriya7");
        when(input.readInputString()).thenReturn("Hchiko");
        checkOutMovieCommand = new CheckOutMovieCommand();
        checkOutMovieCommand.perform(output, input, library);
    }


}
