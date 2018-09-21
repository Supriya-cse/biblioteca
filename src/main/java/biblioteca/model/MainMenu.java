package biblioteca.model;
import biblioteca.view.ConsoleOutputDriver;

import java.util.List;

public enum MainMenu {

    LIST_OF_BOOKS{
        public void act(ConsoleOutputDriver libraryConsoleOutputDriver, List<String> bookDetails){
                libraryConsoleOutputDriver.print("Title,Author,Year");
                for (String string : bookDetails) {
                    libraryConsoleOutputDriver.print(string);
                }
            }
    };

    public abstract void act(ConsoleOutputDriver consoleOutputDriver,List<String> StringList);

}
