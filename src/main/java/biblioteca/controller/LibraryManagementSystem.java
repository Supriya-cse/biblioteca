package biblioteca.controller;

import biblioteca.command.Command;
import biblioteca.command.CommandHelper;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import static biblioteca.common.Constants.*;


public class LibraryManagementSystem {
    private static String[] options = {"Quit Application", "List of Books", "Checkout Book", "Return Book",
            "List of Movies", "Check out Movie","Login"};
    private ConsoleOutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private CommandHelper commandHelper;

    public LibraryManagementSystem(ConsoleOutputDriver libraryConsoleOutputDriver, InputDriver inputDriver, Library library, CommandHelper commandHelper) {
        this.outputDriver = libraryConsoleOutputDriver;
        this.library = library;
        this.inputDriver = inputDriver;
        this.commandHelper = commandHelper;
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
        displayMenu();
        do {
            option = readMenuOptionFromUser();
            Command command = commandBasedOnUserChoice(option);
            command.perform(outputDriver, inputDriver, library);
        } while (option != 0);
    }

    private Command commandBasedOnUserChoice(int option) {
        if (option < options.length) {
            String choice = options[option];
            return this.commandHelper.getCommand(choice);
        }
        return this.commandHelper.getCommand("Invalid command");
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