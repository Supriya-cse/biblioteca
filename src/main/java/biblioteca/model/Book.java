package biblioteca.model;

public class Book {
    private static final String BOOK_REPRESENTATION_FORMAT = "%-35s %-35s %-10d" ;
    private String title;
    private String author;
    private int publishedYear;

    Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return String.format(BOOK_REPRESENTATION_FORMAT, this.title, this.author, this.publishedYear);
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass()!=obj.getClass()){
            return false;
        }
       Book book = (Book)obj;
        return this.title.equals(book.title);
    }
}
