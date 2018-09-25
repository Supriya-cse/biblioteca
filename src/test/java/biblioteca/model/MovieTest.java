package biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MovieTest {
    @Test
    void testForRepresentation() {
        String format = "%-35s %-35s %-10d %-10s";
        Movie aMovie = new Movie("Hachiko", "Nick", 2009, "8");
        String title = "Hachiko";
        int yearReleased = 2009;
        String director = "Nick";
        String rating = "8";
        String expected = String.format(format, title, director, yearReleased, rating);

        assertEquals(expected, aMovie.toString());
    }


    @Test
    void testForNullString() {
        String title = "Hachiko";
        int yearReleased = 1997;
        String director = "Nick";
        String rating = "9";
        Movie movie = new Movie(title, director, yearReleased, rating);

        assertNotEquals(null, movie);
    }

    @Test
    void testForInequality() {
        String title = "Hachiko";
        int yearReleased = 1997;
        String director = "Nick";
        String rating = "9";
        Movie aMovie = new Movie(title, director, yearReleased, rating);
        String movie = "movie";

        assertNotEquals(aMovie, movie);
    }

    @Test
    void testForMovieEquality() {
        String title = "Hachiko";
        int yearReleased = 1997;
        String director = "Nick";
        String rating = "9";
        Movie aMovie = new Movie(title, director, yearReleased, rating);
        Movie sameMovie = new Movie(title, director, yearReleased, rating);

        assertEquals(aMovie, sameMovie);
    }

}