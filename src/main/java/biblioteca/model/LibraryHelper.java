package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryHelper {
    private List<Book> listOfBooks = new ArrayList<>();

    public List<Book> addBooksToTheLibrary() {
        listOfBooks.add(new Book("Harry Potter"));
        listOfBooks.add(new Book("Stephen Hawking"));
        listOfBooks.add(new Book("Sherlock Homes"));
        return listOfBooks;
    }


}
