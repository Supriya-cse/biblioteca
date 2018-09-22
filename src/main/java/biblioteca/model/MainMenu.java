package biblioteca.model;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

import static biblioteca.common.Constants.*;

public enum MainMenu {
    LIST_OF_BOOKS{
        public void act(ConsoleOutputDriver libraryConsoleOutputDriver, InputDriver inputDriver, Library library){
            libraryConsoleOutputDriver.print("Title\t\t\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\tYear\t");
            for (String string : library.getListOfBooks()) {
                libraryConsoleOutputDriver.print(string);
            }
        }
    },
    INVALID_OPTION {
        @Override
        public void act(ConsoleOutputDriver output, InputDriver input, Library library) {
            output.print(INVALID_OPTION_MESSAGE);
        }
    },
    CHECKOUT_BOOK{
        @Override
        public void act(ConsoleOutputDriver output, InputDriver input, Library library) {
            output.print(ENTER_BOOK_NAME_TO_CHECK_OUT);
            String inputString = input.readInputString();
            if(!library.checkOut(inputString)) {
                output.print(BOOK_NOT_AVAILABLE);
            }
            else {
                output.print(SUCCESSFUL_CHECKOUT);
            }
        }
    },
    RETURN_BOOK{
        @Override
        public void act(ConsoleOutputDriver output, InputDriver input, Library library) {
            output.print(ENTER__BOOK_NAME_TO_RETURN);
            String inputString =input.readInputString();
            if(library.returnBook(inputString)){
                output.print(RETURN_SUCCESSFUL);
            }
            else{
                output.print(RETURN_UNSUCCESSFUL);
            }
        }
    };


    public abstract void act(ConsoleOutputDriver consoleOutputDriver, InputDriver inputDriver, Library library);
}
