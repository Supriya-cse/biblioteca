package biblioteca.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {


    @DisplayName("Test for displaying list of items")
    @Test
    void testForDisplayingListOfItems() {
        List<LibraryItem> expectedBookList = new ArrayList<>();

        List<LibraryItem> libraryItems = listOfLibraryItems();
        Library library = new Library(libraryItems);

        expectedBookList.add(new Book("Harry Potter", "JK rowling", 1997));
        expectedBookList.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        expectedBookList.add(new Book("Sherlock Homes", "Arthur Canon", 1996));

        assertEquals(3, library.getListOfLibraryItems(Book.class).size());
        assertEquals(expectedBookList.get(0).toString(), library.getListOfLibraryItems(Book.class).get(0));
        assertEquals(expectedBookList.get(1).toString(), library.getListOfLibraryItems(Book.class).get(1));
        assertEquals(expectedBookList.get(2).toString(), library.getListOfLibraryItems(Book.class).get(2));
    }

    @Test
    void testForCheckOut() {
        String checkOutBook = "Sherlock Homes";
        List<LibraryItem> libraryItems = listOfLibraryItems();
        Library library = new Library(libraryItems);


        library.checkOut(new Book(checkOutBook, null, 1000));

        assertEquals(library.getListOfLibraryItems(Book.class).size(), 2);
        assertEquals(libraryItems.size(), 4);
    }

    @Test
    void testForCheckOutOfTwoBooks() {
        String checkOutBookTitle = "Sherlock Homes";
        String anotherBookTitle = "Stephen Hawking";

        List<LibraryItem> libraryItems = listOfLibraryItems();
        Library library = new Library(libraryItems);

        library.checkOut(new Book(checkOutBookTitle, null, 1000));
        library.checkOut(new Book(anotherBookTitle, null, 2000));

        assertEquals(library.getListOfLibraryItems(Book.class).size(), 1);
        assertEquals(libraryItems.size(), 3);
    }

    @Test
    void testForReturnABook() {
        String checkOutBookTitle = "Sherlock Homes";

        List<LibraryItem> libraryItems = listOfLibraryItems();
        Library library = new Library(libraryItems);

        library.checkOut(new Book(checkOutBookTitle, null, 1000));
        library.returnBook(checkOutBookTitle);

        assertEquals(library.getListOfLibraryItems(Book.class).size(), 3);
        assertEquals(libraryItems.size(), 5);
    }


    private List<LibraryItem> listOfLibraryItems() {
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book("Harry Potter", "JK rowling", 1997));
        libraryItems.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        libraryItems.add(new Book("Sherlock Homes", "Arthur Canon", 1996));
        libraryItems.add(new Movie("Hachiko", 2009, "Nick", "8"));
        libraryItems.add(new Movie("Kushi", 2010, "SjSurya", "10"));
        return libraryItems;
    }

}
