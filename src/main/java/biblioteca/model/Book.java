package biblioteca.model;

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
        return String.valueOf(title+","+author+","+publishedYear);
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        Book book = (Book)obj;
        return book.title == this.title && this.author==book.author && book.publishedYear ==this.publishedYear;
    }
}
