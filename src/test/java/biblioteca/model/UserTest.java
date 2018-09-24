package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    private User libraryUser;

    @BeforeEach
    void beforeEach() {
        this.libraryUser = new User("Supriya", "222-3232", "supriya7", "supriya.muppiri@gmail.com", "9490887155");
    }

    @Test
    void shouldReturnTrueForValidCredentials() {
        assertTrue(libraryUser.checkCredentials("222-3232", "supriya7"));
    }

    @Test
    void shouldReturnFalseForInValidCredentials() {
        assertFalse(libraryUser.checkCredentials("223-1234", "1434"));
    }

    @Test
    void shouldReturnFalseWhenVerifyEqualityBetweenLibraryUserAndNull() {
        assertFalse(this.libraryUser.equals(null));
    }

    @Test
    void shouldReturnFalseWhenVerifyEqualityBetweenLibraryUserAndString() {
        assertFalse(this.libraryUser.equals("libraryUser"));
    }

    @Test
    void shouldReturnTrueWhenVerifyEqualityBetweenLibraryUserAndItSelf() {
        assertTrue(this.libraryUser.equals(this.libraryUser));
    }

}
