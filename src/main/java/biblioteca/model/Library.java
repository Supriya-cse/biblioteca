package biblioteca.model;

//Place to find collection of books

import java.util.ArrayList;
import java.util.List;

public class Library {
    private LibraryHelper libraryHelper = new LibraryHelper();
    private List<Book> checkedOutBooks = new ArrayList<>();
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

    public boolean checkOut(String checkOutBook){
        Book bookToBeCheckedOut= new Book(checkOutBook,null,0);
       for(int var = 0 ;var<books.size();var++){
           if(books.get(var).equals(bookToBeCheckedOut))
           {
               checkedOutBooks.add(books.get(var));
               books.remove(books.get(var));
               return true;
           }
       }
        return false;
    }

    public boolean returnBook(String returnBookDetails) {
        Book bookToBeReturned= new Book(returnBookDetails,null,0);
            for(int var = 0 ;var<checkedOutBooks.size();var++){
                if(checkedOutBooks.get(var).equals(bookToBeReturned))
                {
                    books.add(checkedOutBooks.get(var));
                    checkedOutBooks.remove(books.get(var));
                    return true;
                }
            }
        return false;
    }
    }