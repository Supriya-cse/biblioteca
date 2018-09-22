package biblioteca.model;

import biblioteca.command.*;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

public enum MainMenu {
    QUIT("Quit Application", new QuitCommand()) {},
    LIST_OF_BOOKS("List of Books", new ListBooksCommand()) {},
    CHECKOUT_BOOK("Checkout Book", new CheckOutCommand()) {},
    RETURN_BOOK("Return Book", new ReturnCommand()) {},
    INVALID_OPTION("Invalid Option", new InvalidCommand()) {};
    private String string;
    private Command action;

    MainMenu(String string, Command action) {
        this.string = string;
        this.action = action;
    }

    public void perform(ConsoleOutputDriver output, InputDriver inputDriver, Library library) {
        this.action.perform(output, inputDriver, library);
    }

    public void display() {
        System.out.println(this.ordinal() + " " + this.string);
    }

}