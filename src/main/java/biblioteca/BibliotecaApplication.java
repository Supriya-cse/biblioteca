package biblioteca;

import biblioteca.command.CommandHelper;
import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.CheckoutListener;
import biblioteca.model.Library;
import biblioteca.model.LibraryHelper;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

public class BibliotecaApplication {

    public static void main(String args[]) {
        LibraryHelper libraryHelper = new LibraryHelper();
        CheckoutListener librarian = new CheckoutListener() {
            @Override
            public void inform() {

            }
        };
        Library library = new Library(libraryHelper.listOfLibraryItems(), libraryHelper.listOfUser(), librarian);
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        InputDriver inputDriver = new InputDriver();
        CommandHelper commandHelper = new CommandHelper();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library, commandHelper);
        libraryManagementSystem.start();
    }

}
