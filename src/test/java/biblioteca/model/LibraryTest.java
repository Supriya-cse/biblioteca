package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    @DisplayName("Test for displaying list of books")
    @Test
    void testForDisplayingListOfBooks() {
        List<Book> expectedBookList = new ArrayList<>();
        Library library = new Library();

        expectedBookList.add(new Book("Harry Potter", "JK rowling", 1997));
        expectedBookList.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        expectedBookList.add(new Book("Sherlock Homes", "Arthur Canon", 1996));

        assertEquals(expectedBookList.get(0).toString(),library.getListOfBooks().get(0));

    }
}
