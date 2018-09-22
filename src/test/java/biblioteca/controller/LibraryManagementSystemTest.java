package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import static org.mockito.Mockito.when;

class LibraryManagementSystemTest {

    private ConsoleOutputDriver consoleOutputDriver;
    private LibraryManagementSystem libraryManagementSystem;
    private InputDriver inputDriver;
    private Library library;

    private void setSystemInput(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        inputDriver = Mockito.mock(InputDriver.class);
        library=Mockito.mock(Library.class);
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver,inputDriver,library);
    }

    @Test
    void testForWelcomeMessage() {
        when(inputDriver.readInput()).thenReturn(1).thenReturn(4);
        libraryManagementSystem.start();
        Mockito.verify(consoleOutputDriver).print("Welcome to the Bangalore Library");
    }

    @Test
    void testForMenu(){
        when(inputDriver.readInput()).thenReturn(1).thenReturn(4);
        libraryManagementSystem.start();
        setSystemInput("Harry Potter");
        Mockito.verify(library).getListOfBooks();
    }

    @AfterEach
    private void setUp(){
        System.setIn(System.in);
    }

}