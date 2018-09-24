package biblioteca.model;
import java.util.ArrayList;
import java.util.List;
import static biblioteca.common.Constants.NOT_LOGGED;

//Place to find collection of items

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
        for (User user : users) {
            if (user.checkCredentials(libraryNo, password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public String currentUserInformation() {
        if (isCurrentUserLogged()) {
            return currentUser.toString();
        }
        return NOT_LOGGED;
    }

    public boolean isCurrentUserLogged() {
        return currentUser != null;
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