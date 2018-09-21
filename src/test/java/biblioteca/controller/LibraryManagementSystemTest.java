package biblioteca.controller;

import biblioteca.view.ConsoleOutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LibraryManagementSystemTest {

    private ConsoleOutputDriver consoleOutputDriver;
    private LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver);

    }


    @Test
    void testForWelcomeMessage() {
        libraryManagementSystem.start();
        Mockito.verify(consoleOutputDriver).print("Welcome to the Bangalore Library");
    }

    @Test
    void testForDisplayingHeaderForListOfBooks() {
        libraryManagementSystem.displayBookDetails();
        Mockito.verify(consoleOutputDriver).printListAsColumns("Title,Author,Year");
    }

    @Test
    void testForDisplayingListOfBooks() {
        libraryManagementSystem.displayBookDetails();
        Mockito.verify(consoleOutputDriver).printListAsColumns("Harry Potter,JK rowling,1997");
    }


}