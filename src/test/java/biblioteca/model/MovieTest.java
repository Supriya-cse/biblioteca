package biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void testForRepresentation() {
        String format = "%-35s %-35s %-10d %-10s";
        Movie aMovie = new Movie("Hachiko", 2009, "Nick", "8");
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
        Movie movie = new Movie(title, yearReleased, director, rating);

        assertFalse(movie.equals(null));
    }

    @Test
    void testForInequality() {
        String title = "Hachiko";
        int yearReleased = 1997;
        String director = "Nick";
        String rating = "9";
        Movie aMovie = new Movie(title, yearReleased, director, rating);
        String movie = "movie";

        assertFalse(aMovie.equals(movie));
    }

    @Test
    void testForMovieEquality() {
        String title = "Hachiko";
        int yearReleased = 1997;
        String director = "Nick";
        String rating = "9";
        Movie aMovie = new Movie(title, yearReleased, director, rating);
        Movie sameMovie = new Movie(title, yearReleased, director, rating);

        assertTrue(aMovie.equals(sameMovie));
    }

}