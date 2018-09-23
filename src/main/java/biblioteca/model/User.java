package biblioteca.model;

public class User {
    private static final String REPRESENTATION_FORMAT = "%-35s %-35s %-35s";

    private final String name;
    private final String libraryNo;
    private final String password;
    private final String email;
    private final String phoneNumber;

    public User(String name, String libraryNo, String password, String email, String phoneNumber) {
        this.name = name;
        this.libraryNo = libraryNo;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


}
