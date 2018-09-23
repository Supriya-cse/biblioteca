package biblioteca.model;

public class Movie {
    private static final String format = "%-35s %-35s %-10d %-10s";

    private final String title;
    private final String director;
    private final String rating;
    private final int yearReleased;

    public Movie(String title, int yearReleased, String director, String rating) {
        this.title = title;
        this.yearReleased = yearReleased;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format(format, this.title, this.director, this.yearReleased, this.rating);
    }


    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Movie that = (Movie) object;
        return this.title.equalsIgnoreCase(that.title);

    }

}