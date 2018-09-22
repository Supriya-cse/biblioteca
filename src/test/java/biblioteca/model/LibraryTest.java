package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LibraryTest {

    @DisplayName("Test for displaying list of books")
    @Test
    void testForDisplayingListOfBooks() {
        List<Book> expectedBookList = new ArrayList<>();
        Library library = new Library();

        expectedBookList.add(new Book("Harry Potter", "JK rowling", 1997));
        expectedBookList.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        expectedBookList.add(new Book("Sherlock Homes", "Arthur Canon", 1996));

        assertEquals(expectedBookList.get(0).toString(), library.getListOfBooks().get(0));

    }

    @Test
    void testForTwoBooksToBeEqual() {
        Book book = new Book("Hobbit", "Daniel", 2000);
        Book book2 = new Book("Hobbit", "Daniel", 2000);
        assertEquals(book, book2);
    }

    @Test
    void testForTwoBooksNotToBeEqual() {
        Book book = new Book("Hobbit", "Daniel", 2000);
        Book book2 = new Book("Hobb", "ho", 2000);
        assertNotEquals(book, book2);
    }


    @Test
    void testForCheckOut() {
        String checkOutBook = "Sherlock Homes";
        List<Book> expectedBookList = new ArrayList<>();
        Library library = new Library();

        expectedBookList.add(new Book("Harry Potter", "JK rowling", 1997));
        expectedBookList.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));

        library.checkOut(checkOutBook);

        assertEquals(library.getListOfBooks().size(), expectedBookList.size());
    }

    @Test
    void testForCheckOutOfTwoBooks() {
        String checkOutBook = "Sherlock Homes";
        String anotherBook = "Stephen Hawking";
        List<Book> expectedBookList = new ArrayList<>();
        Library library = new Library();

        expectedBookList.add(new Book("Harry Potter", "JK rowling", 1997));


        library.checkOut(checkOutBook);
        library.checkOut(anotherBook);

        assertEquals(library.getListOfBooks().size(), expectedBookList.size());
    }

}
