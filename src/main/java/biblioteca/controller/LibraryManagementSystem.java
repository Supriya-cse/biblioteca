package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;


public class LibraryManagementSystem {

    private final String WELCOME_MESSAGE = "Welcome to the Banglore Library";
    private ConsoleOutputDriver libraryConsoleOutputDriver = new ConsoleOutputDriver();
    private Library library;

    public void start() {
        message();
        displayBooks();
    }

    void message() {
        libraryConsoleOutputDriver.print(WELCOME_MESSAGE);
    }

    void displayBooks() {
        library = new Library();
        library.displayListOfBooks();
    }
}
