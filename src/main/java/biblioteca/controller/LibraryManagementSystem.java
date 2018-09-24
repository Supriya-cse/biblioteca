package biblioteca.controller;

import biblioteca.command.Command;
import biblioteca.command.CommandFactory;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

//Controls all operations on particular Library
public class LibraryManagementSystem {
    private static String[] options = {"Quit Application", "List of Books", "Checkout Book", "Return Book",
                                       "List of Movies", "Check out Movie", "Login", "Display User Information","Logout"};
    private ConsoleOutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private CommandFactory commandFactory;

    public LibraryManagementSystem(ConsoleOutputDriver libraryConsoleOutputDriver, InputDriver inputDriver, Library library, CommandFactory commandFactory) {
        this.outputDriver = libraryConsoleOutputDriver;
        this.library = library;
        this.inputDriver = inputDriver;
        this.commandFactory = commandFactory;
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
        int option;
        do {
            displayMenu();
            option = readMenuOptionFromUser();
            Command command = commandBasedOnUserChoice(option);
            command.perform(outputDriver, inputDriver, library);
        } while (option != 0);
    }

    private Command commandBasedOnUserChoice(int option) {
        if (option < options.length) {
            String choice = options[option];
            return this.commandFactory.getCommand(choice);
        }
        return this.commandFactory.getCommand("Invalid command");
    }

    private void displayMenu() {
        displayMenuHeader();
        int i = 0;
        for (String option : options) {
            this.outputDriver.print(i + " " + option);
            i++;
        }
    }

}