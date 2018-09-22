package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;
import static biblioteca.model.MainMenu.CHECKOUT_BOOK;
import static biblioteca.model.MainMenu.INVALID_OPTION;
import static biblioteca.model.MainMenu.LIST_OF_BOOKS;


public class LibraryManagementSystem {

    private ConsoleOutputDriver libraryConsoleOutputDriver;
    private InputDriver inputDriver;
    private Library library;

    public LibraryManagementSystem(ConsoleOutputDriver libraryConsoleOutputDriver, InputDriver inputDriver,Library library) {
        this.libraryConsoleOutputDriver = libraryConsoleOutputDriver;
        this.library = library;
        this.inputDriver = inputDriver;
    }


    public void start() {
        message();
        displayMenuOptions();
        displayMenu();
    }

    private void message() {
        libraryConsoleOutputDriver.print(WELCOME_MESSAGE);
    }

    private int readMenuOptionFromUser() {
        libraryConsoleOutputDriver.print("");
        libraryConsoleOutputDriver.print(ENTER_YOUR_OPTION);
        return inputDriver.readInput();
    }


    private void displayMenuOptions() {
        this.libraryConsoleOutputDriver.print("");
        this.libraryConsoleOutputDriver.print(MENU_HEADER);
        this.libraryConsoleOutputDriver.print("Print 1 for ListOfBooks");
        this.libraryConsoleOutputDriver.print("Print 2 for CheckOut Book");
        this.libraryConsoleOutputDriver.print("Print 3 for Quit");
    }



    private void displayMenu() {
        int option;
        int quitOption = 3;
        do {
            option = readMenuOptionFromUser();
            switch (option) {
                case 1:
                    LIST_OF_BOOKS.act(libraryConsoleOutputDriver, inputDriver, library);
                    break;
                case 2:
                    CHECKOUT_BOOK.act(libraryConsoleOutputDriver,inputDriver,library);
                    break;
                case 3:
                    break;
                default:
                    INVALID_OPTION.act(libraryConsoleOutputDriver, inputDriver, library);
                    break;
            }
        }while(option!=quitOption);
    }



}