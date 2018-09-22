package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;
import static biblioteca.model.MainMenu.*;


public class LibraryManagementSystem {

    private ConsoleOutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;

    public LibraryManagementSystem(ConsoleOutputDriver libraryConsoleOutputDriver, InputDriver inputDriver,Library library) {
        this.outputDriver = libraryConsoleOutputDriver;
        this.library = library;
        this.inputDriver = inputDriver;
    }


    public void start() {
        message();
        displayMenu();
    }

    private void message() {
        outputDriver.print(WELCOME_MESSAGE);
    }

    private int readMenuOptionFromUser() {
        displayMenuOptions();
        outputDriver.print("");
        outputDriver.print(ENTER_YOUR_OPTION);
        return inputDriver.readInput();
    }


    private void displayMenuOptions() {
        this.outputDriver.print("");
        this.outputDriver.print(MENU_HEADER);
        this.outputDriver.print("Print 1 for ListOfBooks");
        this.outputDriver.print("Print 2 for CheckOut Book");
        this.outputDriver.print("Print 3 to Return a book");
        this.outputDriver.print("Print 4 to QUIT");
    }



    private void displayMenu() {
        int option;
        int quitOption = 4;
        do {
            option = readMenuOptionFromUser();
            switch (option) {
                case 1:
                    LIST_OF_BOOKS.act(outputDriver, inputDriver, library);
                    break;
                case 2:
                    CHECKOUT_BOOK.act(outputDriver,inputDriver,library);
                    break;
                case 3:
                    RETURN_BOOK.act(outputDriver,inputDriver,library);
                    break;
                default:
                    INVALID_OPTION.act(outputDriver, inputDriver, library);
                    break;
            }
        }while(option!=quitOption);
    }



}