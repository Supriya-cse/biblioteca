package biblioteca.model;

//Place to find collection of books

import java.util.ArrayList;
import java.util.List;

public class Library {
    private LibraryHelper libraryHelper = new LibraryHelper();
    private List<Book> books;

    public Library() {
        this.books = libraryHelper.listOfLibraryItems();
    }

     public List<String> getListOfBooks() {
         List<String> bookDetails = new ArrayList<>();
        for (Book book : books) {
            bookDetails.add(book.toString());
        }
        return bookDetails;
    }

    public void checkOut(String checkOutBook){
        Book bookToBeCheckedOut= new Book(checkOutBook,null,0);
       for(int var = 0 ;var<books.size();var++){
           if(books.get(var).equals(bookToBeCheckedOut))
           {
               books.remove(books.get(var));
               break;
           }
       }
    }
}