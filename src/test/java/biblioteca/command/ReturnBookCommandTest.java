package biblioteca.command;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.model.LibraryHelper;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ReturnBookCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private ReturnBookCommand returnBookCommand;
    private LibraryHelper libraryHelper;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        libraryHelper = new LibraryHelper();
        library = new Library(libraryHelper.listOfLibraryItems(), libraryHelper.listOfUser());
        library.authenticate("222-3232", "supriya7");

    }

    @DisplayName("should return a book that is present in the checkedout list of the library")
    @Test
    void testForReturningBookThatIsCheckedOut() {
        when(input.readInputString()).thenReturn("Harry Potter");
        library.checkOutItem(new Book("Harry Potter", null, 0));
        returnBookCommand = new ReturnBookCommand();
        returnBookCommand.perform(output, input, library);
        assertTrue(library.returnItem(new Book("Harry Potter", null, 0)));
    }


    @DisplayName("should return a book that is present in the checkedout list of the library")
    @Test
    void testForNotReturningBookThatIsNotCheckedOut() {
        when(input.readInputString()).thenReturn("Harry Potter");
        returnBookCommand = new ReturnBookCommand();
        returnBookCommand.perform(output, input, library);
        assertFalse(library.returnItem(new Book("Harry Potter", null, 0)));
    }
}