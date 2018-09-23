package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.Movie;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class CheckOutMovieCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private CheckOutMovieCommand checkOutMovieCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(biblioteca.view.ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);

    }

    @DisplayName("should checkout a book that is present in the book list of the library")
    @Test
    void testForCheckingBookThatExistsInLibrary() {
        when(input.readInputString()).thenReturn("Hachiko");
        checkOutMovieCommand = new CheckOutMovieCommand();
        checkOutMovieCommand.perform(output, input, library);
        Mockito.verify(library).checkOut(new Movie("Hachiko", null, 1000, "9"));
    }


}
