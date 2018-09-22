package biblioteca.model;

import static biblioteca.common.Constants.BOOK_REPRESENTATION_FORMAT;

public class Book {
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return this.title.equals(book.title);
    }
}
