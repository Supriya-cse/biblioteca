package biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookTest {

    @Test
    void testForTwoBooksToBeEqual() {
        Book book = new Book("Hobbit", "Daniel", 2000);
        Book book2 = new Book("Hobbit", "Daniel", 2000);
        assertEquals(book, book2);
    }

    @Test
    void testForTwoBooksNotToBeEqual() {
        Book book = new Book("Hobbit", "Daniel", 2000);
        Book book2 = new Book("Hobb", "ho", 2000);
        assertNotEquals(book, book2);
    }
}
