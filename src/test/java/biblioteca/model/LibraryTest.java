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

        expectedBookList.add(new Book("Harry Potter"));
        expectedBookList.add(new Book("Stephen Hawking"));
        expectedBookList.add(new Book("Sherlock Homes"));

        assertEquals(expectedBookList.get(0).toString(),library.displayListOfBooks().get(0));

    }
}
