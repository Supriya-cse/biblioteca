package biblioteca.model;

import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;


public class MainMenuTest {

    private ConsoleOutputDriver consoleOutputDriver;
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



}
