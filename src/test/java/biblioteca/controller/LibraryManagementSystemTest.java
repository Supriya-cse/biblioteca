package biblioteca.controller;

import biblioteca.model.MainMenu;
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

    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver);
        inputDriver = Mockito.mock(InputDriver.class);

    }

    @Test
    void testForWelcomeMessage() {
        libraryManagementSystem.start();

        Mockito.verify(consoleOutputDriver).print("Welcome to the Bangalore Library");
    }

    @Test
    void testForMenu(){
        when(inputDriver.readInput()).thenReturn("1");
    }



}