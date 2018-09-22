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
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver,inputDriver,library);
    }

    @Test
    void testForWelcomeMessage() {
        libraryManagementSystem.start();
        when(inputDriver.readInput()).thenReturn(1).thenReturn(3);
        Mockito.verify(consoleOutputDriver).print("Welcome to the Bangalore Library");
    }

    @Test
    void testForMenu(){
        libraryManagementSystem.start();
        when(inputDriver.readInput()).thenReturn(1).thenReturn(3);
        Mockito.verify(inputDriver).readInput();
    }



}