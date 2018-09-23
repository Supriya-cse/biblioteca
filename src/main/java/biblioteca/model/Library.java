package biblioteca.model;

//Place to find collection of items

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> checkedOutItems = new ArrayList<>();
    private List<LibraryItem> items;

    public Library(List<LibraryItem> libraryItems) {
        this.items = libraryItems;
    }

    public List<String> getListOfLibraryItems(Class<? extends LibraryItem> itemClass) {
        List<String> requiredItems = new ArrayList<>();
        for (LibraryItem libraryItem : items) {
            if (itemClass.equals(libraryItem.getClass())) {
                requiredItems.add(libraryItem.toString());
            }
        }
        return requiredItems;
    }

    public boolean checkOut(String checkOutBook) {
        Book bookToBeCheckedOut = new Book(checkOutBook, null, 0);
        for (int var = 0; var < items.size(); var++) {
            if (items.get(var).equals(bookToBeCheckedOut)) {
                checkedOutItems.add(items.get(var));
                items.remove(items.get(var));
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String returnBookDetails) {
        Book bookToBeReturned = new Book(returnBookDetails, null, 0);
        for (int var = 0; var < checkedOutItems.size(); var++) {
            if (checkedOutItems.get(var).equals(bookToBeReturned)) {
                items.add(checkedOutItems.get(var));
                checkedOutItems.remove(items.get(var));
                return true;
            }
        }
        return false;
    }
}