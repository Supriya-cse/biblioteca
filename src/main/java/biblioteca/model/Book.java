package biblioteca.model;

class Book {
    private String title;

    Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.valueOf(title);
    }
}
