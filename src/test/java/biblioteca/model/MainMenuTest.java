package biblioteca.model;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class MainMenuTest {

    private ConsoleOutputDriver consoleOutputDriver;
    private Library library;
    private InputDriver inputDriver;

    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        library = new Library();
        inputDriver=Mockito.mock(InputDriver.class);
    }

    @Test
    void testForHeaderOfListOfBooks(){
        MainMenu.LIST_OF_BOOKS.act(consoleOutputDriver, inputDriver, library);
        Mockito.verify(consoleOutputDriver).print("Title\t\t\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\tYear\t");
    }

    @Test
    void testForDisplayingListOfBooks() {
            MainMenu.LIST_OF_BOOKS.act(consoleOutputDriver, inputDriver, library);
            Mockito.verify(consoleOutputDriver).print("Harry Potter                        JK rowling                          1997      ");
        }

    }
