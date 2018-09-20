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

        expectedBookList.add(new Book("Harry Potter"));
        expectedBookList.add(new Book("Stephen Hawking"));
        expectedBookList.add(new Book("Sherlock Homes"));

        assertEquals(libraryHelper.addBooksToTheLibrary().get(1).toString(), expectedBookList.get(0).toString());


    }
}