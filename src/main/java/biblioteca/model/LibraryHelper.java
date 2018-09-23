package biblioteca.model;

import java.util.ArrayList;
import java.util.List;


public class LibraryHelper {
    private List<LibraryItem> libraryItems = new ArrayList<>();

    public List<LibraryItem> listOfLibraryItems() {
        libraryItems.add(new Book("Harry Potter", "JK rowling", 1997));
        libraryItems.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        libraryItems.add(new Book("Sherlock Homes", "Arthur Canon", 1996));
        libraryItems.add(new Movie("Hachiko", 2009, "Nick", "8"));
        libraryItems.add(new Movie("Kushi", 2010, "SjSurya", "10"));
        return libraryItems;
    }


}
