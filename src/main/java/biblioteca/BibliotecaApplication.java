package biblioteca;

import biblioteca.command.CommandFactory;
import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.Library;
import biblioteca.model.LibraryHelper;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

public class BibliotecaApplication {

    public static void main(String args[]) {
        LibraryHelper libraryHelper = new LibraryHelper();
        Library library = new Library(libraryHelper.listOfLibraryItems());
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        InputDriver inputDriver = new InputDriver();
        CommandFactory commandFactory = new CommandFactory();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library, commandFactory);
        libraryManagementSystem.start();
    }

}
