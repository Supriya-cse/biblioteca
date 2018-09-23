package biblioteca.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputDriverTest {
    private void setSystemInput(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @Test
    void testMainMenuInput() {
        setSystemInput("0\n");
        InputDriver inputDriver = new InputDriver();
        assertEquals(0, inputDriver.readInput());
    }

    @Test
    void testMainMenuInputAsString() {
        setSystemInput("hello\n");
        InputDriver inputDriver = new InputDriver();
        assertEquals("hello", inputDriver.readInputString());
    }

    @AfterEach
    private void setUp() {
        System.setIn(System.in);
    }


}
