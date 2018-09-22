package biblioteca.model;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.ENTER_BOOK_TO_CHECKED_OUT;

public enum MainMenu {
    LIST_OF_BOOKS{
        public void act(ConsoleOutputDriver libraryConsoleOutputDriver, InputDriver inputDriver, Library library){
            libraryConsoleOutputDriver.print("Title\t\t\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\tYear\t");
            for (String string : library.getListOfBooks()) {
                libraryConsoleOutputDriver.print(string);
            }
        }
    },
    INVALID_OPTION{
        @Override
        public void act(ConsoleOutputDriver consoleOutputDriver, InputDriver inputDriver, Library library) {
            consoleOutputDriver.print("Select a valid option!");
        }
    },
    CHECKOUT_BOOK{
        private String checkoutBook(ConsoleOutputDriver consoleOutputDriver,InputDriver inputDriver) {
            consoleOutputDriver.print("");
            consoleOutputDriver.print(ENTER_BOOK_TO_CHECKED_OUT);
            return inputDriver.readInputString();
        }
        @Override
        public void act(ConsoleOutputDriver consoleOutputDriver, InputDriver inputDriver, Library library) {
            library.checkOut(checkoutBook(consoleOutputDriver,inputDriver));
        }

    };



    public abstract void act(ConsoleOutputDriver consoleOutputDriver, InputDriver inputDriver, Library library);
}
