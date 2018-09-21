package biblioteca;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.view.ConsoleOutputDriver;

public class BibliotecaApplication {

    public static void main(String args[]) {
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver);
        libraryManagementSystem.start();
        libraryManagementSystem.displayBookDetails();
    }

}
