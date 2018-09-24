package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.LibraryHelper;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static biblioteca.common.Constants.BOOK_NOT_AVAILABLE;
import static biblioteca.common.Constants.SUCCESSFUL_CHECKOUT;
import static org.mockito.Mockito.when;

class CheckOutBookCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private CheckOutBookCommand checkOutBookCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        LibraryHelper libraryHelper = new LibraryHelper();
        library = new Library(libraryHelper.listOfLibraryItems(), libraryHelper.listOfUser());
        library.authenticate("222-3232", "supriya7");
    }

    @DisplayName("should checkout a book that is present in the book list of the library")
    @Test
    void testForCheckingBookThatExistsInLibrary() {
        when(input.readInputString()).thenReturn("Harry Potter");
        checkOutBookCommand = new CheckOutBookCommand();
        checkOutBookCommand.perform(output, input, library);
        Mockito.verify(output).print(SUCCESSFUL_CHECKOUT);
    }

    @DisplayName("should checkout a book that is not present in the book list of the library")
    @Test
    void testForCheckingBookThatDoesNotExistsInLibrary() {
        when(input.readInputString()).thenReturn("sfjal");
        checkOutBookCommand = new CheckOutBookCommand();
        checkOutBookCommand.perform(output, input, library);
        Mockito.verify(output).print(BOOK_NOT_AVAILABLE);
    }

}
