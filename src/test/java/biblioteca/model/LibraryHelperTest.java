package biblioteca.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryHelperTest {
    @Test
    void testForAddingBooks() {
        List<Book> expectedBookList = new ArrayList<>();
        LibraryHelper libraryHelper = new LibraryHelper();

        expectedBookList.add(new Book("Harry Potter", "JK rowling", 1997));
        expectedBookList.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        expectedBookList.add(new Book("Sherlock Homes", "Arthur Canon", 1996));

        assertEquals(libraryHelper.listOfLibraryItems().get(0).toString(), expectedBookList.get(0).toString());
    }
}