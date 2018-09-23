package biblioteca;

import biblioteca.command.CommandFactory;
import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

public class BibliotecaApplication {

    public static void main(String args[]) {
        Library library = new Library();
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
        InputDriver inputDriver=new InputDriver();
        CommandFactory commandFactory=new CommandFactory();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver,inputDriver,library,commandFactory);
        libraryManagementSystem.start();
    }

}
