package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class LibraryManagementSystemTest {

    private ConsoleOutputDriver consoleOutputDriver;
    private LibraryManagementSystem libraryManagementSystem;
    private InputDriver inputDriver;
    private Library library;


    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        inputDriver = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);

    }

    @Test
    void testForWelcomeMessage() {
        when(inputDriver.readInput()).thenReturn(1).thenReturn(0);
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library);
        libraryManagementSystem.start();
        Mockito.verify(consoleOutputDriver).print("Welcome to the Bangalore Library");
    }

    @Test
    void testForMenu() {
        when(inputDriver.readInput()).thenReturn(1).thenReturn(0);
        when(inputDriver.readInputString()).thenReturn("Harry Potter");
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library);
        libraryManagementSystem.start();
        Mockito.verify(library).getListOfBooks();
    }


}