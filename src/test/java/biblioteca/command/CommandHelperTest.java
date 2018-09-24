package biblioteca.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandHelperTest {
    private CommandHelper commandHelper;

    @BeforeEach
    void setUp() {
        commandHelper = new CommandHelper();
    }

    @Test
    void testForQuitCommand() {
        Command command = this.commandHelper.getCommand("quit application");
        assertEquals(command.getClass(), QuitCommand.class);
    }


    @Test
    void testForListOfBooksCommand() {
        Command command = this.commandHelper.getCommand("list of books");
        assertEquals(command.getClass(), ListBooksCommand.class);
    }

    @Test
    void testForReturnBookCommand() {
        Command command = this.commandHelper.getCommand("return book");
        assertEquals(command.getClass(), ReturnBookCommand.class);
    }

    @Test
    void testForCheckoutCommand() {
        Command command = this.commandHelper.getCommand("checkout book");
        assertEquals(command.getClass(), CheckOutBookCommand.class);
    }

    @Test
    void testForInvalidCommand() {
        Command command = this.commandHelper.getCommand("");
        assertEquals(command.getClass(), InvalidCommand.class);
    }

    @Test
    void testForListMoviesCommand() {
        Command command = this.commandHelper.getCommand("list of movies");
        assertEquals(command.getClass(), ListMoviesCommand.class);
    }

}