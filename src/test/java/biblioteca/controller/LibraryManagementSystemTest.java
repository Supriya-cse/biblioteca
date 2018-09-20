package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LibraryManagementSystemTest {

    @Test
    void testForWelcomeMessage() {
        ConsoleOutputDriver consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        Mockito.verify(consoleOutputDriver).print("Welcome Message");
    }

    @Test
    void testForDisplayingListOfBooks() {
        Library library = Mockito.mock(Library.class);
        Mockito.verify(library).displayListOfBooks();
    }


}