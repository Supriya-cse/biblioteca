package biblioteca.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryTest {
    private CommandFactory commandFactory;

    @BeforeEach
    void setUp() {
        commandFactory = new CommandFactory();
    }

    @Test
    void testForQuitCommand(){
        Command command = this.commandFactory.getCommand("quit application");
        assertEquals(command.getClass(), QuitCommand.class);
    }


    @Test
    void testForListOfBooksCommand(){
        Command command = this.commandFactory.getCommand("list of books");
        assertEquals(command.getClass(), ListBooksCommand.class);
    }

    @Test
    void testForReturnBookCommand(){
        Command command = this.commandFactory.getCommand("return book");
        assertEquals(command.getClass(), ReturnCommand.class);
    }

    @Test
    void testForCheckoutCommand(){
        Command command = this.commandFactory.getCommand("checkout book");
        assertEquals(command.getClass(), CheckOutCommand.class);
    }

    @Test
    void testForInvalidCommand(){
        Command command = this.commandFactory.getCommand("");
        assertEquals(command.getClass(), InvalidCommand.class);
    }


}