package biblioteca.command;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ReturnBookCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private ReturnBookCommand returnBookCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);

    }

    @DisplayName("should checkout a book that is present in the book list of the library")
    @Test
    void testForCheckingBookThatExistsInLibrary() {
        when(input.readInputString()).thenReturn("Harry Potter");
        returnBookCommand = new ReturnBookCommand();
        returnBookCommand.perform(output, input, library);
        Mockito.verify(library).returnItem(new Book("Harry Potter", null, 0));
    }


}