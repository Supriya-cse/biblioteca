package biblioteca.model;

//Place to find collection of items

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> checkedOutItems = new ArrayList<>();
    private List<LibraryItem> items;
    private List<User> users;
    private User currentUser;

    public Library(List<LibraryItem> libraryItems, List<User> users) {
        this.items = libraryItems;
        this.users = users;
        this.currentUser = null;
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

    public boolean authenticate(String libraryNo, String password) {
        for (int var = 0; var < users.size(); var++) {
            if (users.get(var).checkCredentials(libraryNo, password)) {
                currentUser = users.get(var);
                return true;
            }
        }
        return false;
    }

    public boolean isLogged() {
        if (currentUser == null) {
            return false;
        }
        return true;
    }


    public boolean checkOutItem(LibraryItem checkoutItem) {
        for (int var = 0; var < items.size(); var++) {
            if (items.get(var).equals(checkoutItem)) {
                checkedOutItems.add(items.get(var));
                items.remove(items.get(var));
                return true;
            }
        }
        return false;
    }

    public boolean returnItem(LibraryItem returnItem) {
        for (int var = 0; var < checkedOutItems.size(); var++) {
            if (checkedOutItems.get(var).equals(returnItem)) {
                items.add(checkedOutItems.get(var));
                checkedOutItems.remove(items.get(var));
                return true;
            }
        }
        return false;
    }
}