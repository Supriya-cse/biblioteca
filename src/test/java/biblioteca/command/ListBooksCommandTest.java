package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import biblioteca.model.Book;

import java.util.ArrayList;

import static biblioteca.common.Constants.BOOK_REPRESENTATION_FORMAT;
import static org.mockito.Mockito.when;

class ListBooksCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private ListBooksCommand listBooksCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);
        ArrayList<String> books = new ArrayList<>();
        books.add(String.format(BOOK_REPRESENTATION_FORMAT, "HarryPotter", "Jk rowling", 1997));
        books.add(String.format(BOOK_REPRESENTATION_FORMAT, "Stephen Hawking", "Kristin Larsen", 1998));
        books.add(String.format(BOOK_REPRESENTATION_FORMAT, "Sherlock Homes", "Arthur Canon", 1996));
        when(library.getListOfLibraryItems(Book.class)).thenReturn(books);
        listBooksCommand = new ListBooksCommand();
        listBooksCommand.perform(output, input, library);
    }

    @DisplayName("should display header for list of books")
    @Test
    void testForHeaderOfListOfBooks() {
        Mockito.verify(output).print("Title\t\t\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\tYear\t");
    }


    @DisplayName("Should display no books available if there are no books in library")
    @Test
    void testForDisplayingBooksAvailable() {

        Mockito.verify(output).print(String.format(BOOK_REPRESENTATION_FORMAT, "HarryPotter", "Jk rowling", 1997));
        Mockito.verify(output).print(String.format(BOOK_REPRESENTATION_FORMAT, "Stephen Hawking", "Kristin Larsen", 1998));
        Mockito.verify(output).print(String.format(BOOK_REPRESENTATION_FORMAT, "Sherlock Homes", "Arthur Canon", 1996));
    }

}
