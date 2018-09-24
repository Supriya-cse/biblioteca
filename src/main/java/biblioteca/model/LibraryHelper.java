package biblioteca.model;

import java.util.ArrayList;
import java.util.List;


public class LibraryHelper {
    private List<LibraryItem> libraryItems = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public List<LibraryItem> listOfLibraryItems() {
        libraryItems.add(new Book("Harry Potter", "JK rowling", 1997));
        libraryItems.add(new Book("Stephen Hawking", "Kristin Larsen", 1998));
        libraryItems.add(new Book("Sherlock Homes", "Arthur Canon", 1996));
        libraryItems.add(new Movie("Hachiko", "Nick", 2009, "8"));
        libraryItems.add(new Movie("Kushi", "SjSurya", 2010, "10"));
        return libraryItems;
    }

    public List<User> listOfUser() {
        users.add(new User("Supriya", "222-3232", "supriya7", "supriya.muppiri@gmail.com", "9490887155"));
        users.add(new User("Sunil", "222-3231", "sunilyedla7", "sunil.yedla@gmail.com", "9492607232"));
        users.add(new User("Daya", "222-3233", "dayagaru7", "daya.mani@gmail.com", "99088754251"));
        return users;
    }



}
