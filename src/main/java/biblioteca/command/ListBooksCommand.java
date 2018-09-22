package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

public class ListBooksCommand implements Command {
    private static final String HEADER = "Title\t\t\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\tYear\t";

    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        output.print(HEADER);
        for (String string : library.getListOfBooks()) {
            output.print(string);
        }
    }
}
