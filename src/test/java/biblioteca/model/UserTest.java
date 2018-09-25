package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertNotEquals(null, this.libraryUser);
    }

    @Test
    void shouldReturnFalseWhenVerifyEqualityBetweenLibraryUserAndString() {
        assertNotEquals("libraryUser", this.libraryUser);
    }

    @Test
    void shouldReturnTrueWhenVerifyEqualityBetweenLibraryUserAndItSelf() {
        assertEquals(this.libraryUser, this.libraryUser);
    }

}
