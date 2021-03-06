package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {
    private List<LibraryItem> libraryItems;
    private Library library;

    @BeforeEach
    void init() {
        libraryItems = listOfLibraryItems();
        List<User> users = listOfUser();
        library = new Library(libraryItems, users);
    }

    @DisplayName("Test for displaying list of items")
    @Test
    void testForDisplayingListOfItems() {
        List<LibraryItem> expectedBookList = new ArrayList<>();

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
        library.authenticate("222-3232", "supriya7");
        library.checkOutItem(new Book(checkOutBook, null, 1000));

        assertEquals(library.getListOfLibraryItems(Book.class).size(), 2);
        assertEquals(libraryItems.size(), 4);
    }

    @Test
    void testForCheckOutOfTwoBooks() {
        String checkOutBookTitle = "Sherlock Homes";
        String anotherBookTitle = "Stephen Hawking";
        library.authenticate("222-3232", "supriya7");
        library.checkOutItem(new Book(checkOutBookTitle, null, 1000));
        library.checkOutItem(new Book(anotherBookTitle, null, 2000));

        assertEquals(library.getListOfLibraryItems(Book.class).size(), 1);
        assertEquals(libraryItems.size(), 3);
    }

    @Test
    void testForReturnABook() {
        String checkOutBookTitle = "Sherlock Homes";
        library.authenticate("222-3232", "supriya7");
        library.checkOutItem(new Book(checkOutBookTitle, null, 1000));
        library.returnItem(new Book(checkOutBookTitle, null, 1000));

        assertEquals(library.getListOfLibraryItems(Book.class).size(), 3);
        assertEquals(libraryItems.size(), 5);
    }

    @DisplayName("should return true for authenticating valid users ")
    @Test
    void testForAuthenticatingValidUsers() {

        assertTrue(library.authenticate("222-3232", "supriya7"));
    }

    @DisplayName("should return true if current user is logged in ")
    @Test
    void testForIsLoggedUsers() {
        library.authenticate("222-3232", "supriya7");
        assertTrue(library.isCurrentUserLogged());
    }

    @DisplayName("should logout current user")
    @Test
    void testForLogOut() {
        library.authenticate("222-3232", "supriya7");
        assertTrue(library.logout());
    }

    @DisplayName("should return current user information")
    @Test
    void testForDisplayingCurrentInformation() {
        library.authenticate("222-3232", "supriya7");
        String expectedString = "Supriya supriya.muppiri@gmail.com 9490887155";
        assertEquals(library.currentUserInformation(), expectedString);
    }


    private List<LibraryItem> listOfLibraryItems() {
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book("Harry Potter", "JK rowling", 1997));
        libraryItems.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        libraryItems.add(new Book("Sherlock Homes", "Arthur Canon", 1996));
        libraryItems.add(new Movie("Hachiko", "Nick", 2009, "8"));
        libraryItems.add(new Movie("Kushi", "SjSurya", 2010, "10"));
        return libraryItems;
    }

    private List<User> listOfUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("Supriya", "222-3232", "supriya7", "supriya.muppiri@gmail.com", "9490887155"));
        users.add(new User("Sunil", "222-3231", "sunilyedla7", "sunil.yedla@gmail.com", "9492607232"));
        users.add(new User("Daya", "222-3233", "dayagaru7", "daya.mani@gmail.com", "99088754251"));
        return users;
    }


}
