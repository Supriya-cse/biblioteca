package biblioteca.model;

import java.util.ArrayList;
import java.util.List;



public class LibraryHelper {
    private List<Book> listOfBooks = new ArrayList<>();

    List<Book> listOfLibraryItems() {
        listOfBooks.add(new Book("Harry Potter", "JK rowling", 1997));
        listOfBooks.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        listOfBooks.add(new Book("Sherlock Homes", "Arthur Canon", 1996));
        return listOfBooks;
    }


}
