package biblioteca.controller;
import biblioteca.model.Library;
import biblioteca.model.MainMenu;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;


public class LibraryManagementSystem {

    private ConsoleOutputDriver libraryConsoleOutputDriver;
    private InputDriver inputDriver;
    private MainMenu menu;
    private Library library;

    public LibraryManagementSystem(ConsoleOutputDriver libraryConsoleOutputDriver) {
        this.libraryConsoleOutputDriver = libraryConsoleOutputDriver;
        this.inputDriver = new InputDriver();
        this.library = new Library();
    }


    public void start() {
        message();
        displayMenu();
        representationOfMenuBasedOnChoice();
    }

    private void message() {
        libraryConsoleOutputDriver.print(WELCOME_MESSAGE);
    }

    private String readMenuOptionFromUser() {
        this.libraryConsoleOutputDriver.print(ENTER_YOUR_OPTION);
        return this.inputDriver.readInput();
    }


    private void displayMenu() {
        this.libraryConsoleOutputDriver.print(LINE_SEPERATOR);
        this.libraryConsoleOutputDriver.print(MENU_HEADER);
        this.libraryConsoleOutputDriver.print("Print 1 for ListOfBooks");
        this.libraryConsoleOutputDriver.print("Print 2 for Quit");
    }


    private void representationOfMenuBasedOnChoice() {
        MainMenu menu[] = MainMenu.values();
        int input = Integer.parseInt(readMenuOptionFromUser());
            for (MainMenu element : menu
            ) {
                if (input == element.ordinal() + 1) {
                    element.act(libraryConsoleOutputDriver, library.getListOfBooks());
                }
            }
    }
}


