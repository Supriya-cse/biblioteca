package biblioteca.command;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;

//Command to display list of books to library
public class ListBooksCommand implements Command {
    private static final String HEADER = "Title\t\t\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\tYear\t";

    @Override
    public void perform(ConsoleOutputDriver output, InputDriver input, Library library) {
        output.print(HEADER);
        for (String string : library.getListOfLibraryItems(Book.class)) {
            output.print(string);
        }
    }
}
