package biblioteca.model;
import biblioteca.view.ConsoleOutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class MainMenuTest {

    private ConsoleOutputDriver consoleOutputDriver;
    private Library library;

    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        library = new Library();
    }

    @Test
    void testForHeaderOfListOfBooks(){
        MainMenu.LIST_OF_BOOKS.act(consoleOutputDriver,library.getListOfBooks());
        Mockito.verify(consoleOutputDriver).print("Title,Author,Year");
    }

    @Test
    void testForDisplayingListOfBooks() {
            MainMenu.LIST_OF_BOOKS.act(consoleOutputDriver,library.getListOfBooks());
            Mockito.verify(consoleOutputDriver).print("Harry Potter                        JK rowling                          1997      ");
        }

    }
