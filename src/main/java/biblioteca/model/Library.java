package biblioteca.model;

//Place to find collection of books

import java.util.ArrayList;
import java.util.List;

public class Library {
    private LibraryHelper libraryHelper = new LibraryHelper();
    private List<Book> books;

    public Library() {
        this.books = libraryHelper.addBooksToTheLibrary();
    }

    public List<String> displayListOfBooks() {
        List<String> listOfBooks = new ArrayList<>();
        for (Book book : books) {
            listOfBooks.add(book.toString());
        }
        return listOfBooks;
    }
}