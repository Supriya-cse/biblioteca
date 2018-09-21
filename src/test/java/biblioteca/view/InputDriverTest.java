package biblioteca.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputDriverTest {
    @Test
    void testMainMenuInput(){
        setInput("0\n");
        InputDriver inputDriver = new InputDriver();
        assertEquals(0,Integer.parseInt(inputDriver.readInput()));
    }
    private void setInput(String string){
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

}
