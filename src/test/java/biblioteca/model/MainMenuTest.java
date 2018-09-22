package biblioteca.model;

import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;


public class MainMenuTest {

/*    private ConsoleOutputDriver consoleOutputDriver;
    private Library library;
    private InputDriver inputDriver;

    private void setSystemInput(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        library = new Library();
        inputDriver = Mockito.mock(InputDriver.class);
    }

    @Test
    void testForHeaderOfListOfBooks() {
        MainMenu.LIST_OF_BOOKS.act(consoleOutputDriver, inputDriver, library);
        Mockito.verify(consoleOutputDriver).print("Title\t\t\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\tYear\t");
    }

    @Test
    void testForDisplayingListOfBooks() {
        MainMenu.LIST_OF_BOOKS.act(consoleOutputDriver, inputDriver, library);
        Mockito.verify(consoleOutputDriver).print("Harry Potter                        JK rowling                          1997      ");
    }

    @Test
    void testForInvalidOption() {
        MainMenu.INVALID_OPTION.act(consoleOutputDriver, inputDriver, library);
        Mockito.verify(consoleOutputDriver).print("Select a valid option!");
    }

    @Test
    void testForNotAvailableBookCheckoutMessage() {
        MainMenu.CHECKOUT_BOOK.act(consoleOutputDriver, inputDriver, library);
        Mockito.verify(consoleOutputDriver).print("Sorry! Book is not available");
    }

    @Test
    void testForBookReturn() {
        MainMenu.RETURN_BOOK.act(consoleOutputDriver, inputDriver, library);
        setSystemInput("Harry Potter");
        

    }

*/
}
