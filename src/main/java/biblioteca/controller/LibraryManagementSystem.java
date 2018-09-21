package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;

import java.util.List;


public class LibraryManagementSystem {

    private final String WELCOME_MESSAGE = "Welcome to the Bangalore Library";
    private ConsoleOutputDriver libraryConsoleOutputDriver;
    private Library library = new Library();

    public LibraryManagementSystem(ConsoleOutputDriver libraryConsoleOutputDriver) {
        this.libraryConsoleOutputDriver = libraryConsoleOutputDriver;
    }

    public void displayBookDetails() {
        displayBooks(library.getListOfBooks());
    }

    public void start() {
        message();
    }

    private void message() {
        libraryConsoleOutputDriver.print(WELCOME_MESSAGE);
    }

    private void displayBooks(List<String> bookDetails) {
        libraryConsoleOutputDriver.printListAsColumns("Title,Author,Year");

        for (String string : bookDetails) {
            libraryConsoleOutputDriver.printListAsColumns(string);
        }
    }
}
