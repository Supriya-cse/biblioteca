package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.MainMenu;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;


public class LibraryManagementSystem {

    private ConsoleOutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;

    public LibraryManagementSystem(ConsoleOutputDriver libraryConsoleOutputDriver, InputDriver inputDriver, Library library) {
        this.outputDriver = libraryConsoleOutputDriver;
        this.library = library;
        this.inputDriver = inputDriver;
    }


    public void start() {
        message();
        menuSelection();
    }

    private void message() {
        outputDriver.print(WELCOME_MESSAGE);
    }

    private int readMenuOptionFromUser() {
        outputDriver.print("");
        outputDriver.print(ENTER_YOUR_OPTION);
        return inputDriver.readInput();
    }


    private void displayMenuHeader() {
        this.outputDriver.print("");
        this.outputDriver.print(MENU_HEADER);
    }

    private void menuSelection() {
        MainMenu menu[] = MainMenu.values();
        int option;
        displayMenu(menu);
       do {
            option = readMenuOptionFromUser();
            if (option < menu.length) {
                MainMenu choice = menu[option];
                choice.perform(outputDriver, inputDriver, library);
            }
        }while (option!=0);
    }

    private void displayMenu(MainMenu[] menu) {
         displayMenuHeader();
        for (MainMenu menu1:menu) {
            menu1.display();
        }
    }


}