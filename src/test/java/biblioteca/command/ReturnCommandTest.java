package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class ReturnCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private ReturnCommand returnCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);
    }


    @DisplayName("should return a book if it is already checked out")
    @Test
    void testForReturningBookThatIsCheckedOutAlready() {
        when(input.readInputString()).thenReturn("Harry Potter");
        returnCommand = new ReturnCommand();
        returnCommand.perform(output, input, library);
        Mockito.verify(library).returnBook("Harry Potter");
    }

}