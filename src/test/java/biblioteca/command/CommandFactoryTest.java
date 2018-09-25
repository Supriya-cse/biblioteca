package biblioteca.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandFactoryTest {
    private CommandFactory commandFactory;

    @BeforeEach
    void setUp() {
        commandFactory = new CommandFactory();
    }

    @Test
    void testForQuitCommand() {
        Command command = this.commandFactory.getCommand("quit application");
        assertEquals(command.getClass(), QuitCommand.class);
    }


    @Test
    void testForListOfBooksCommand() {
        Command command = this.commandFactory.getCommand("list of books");
        assertEquals(command.getClass(), ListBooksCommand.class);
    }

    @Test
    void testForReturnBookCommand() {
        Command command = this.commandFactory.getCommand("return book");
        assertEquals(command.getClass(), ReturnBookCommand.class);
    }

    @Test
    void testForCheckoutCommand() {
        Command command = this.commandFactory.getCommand("checkout book");
        assertEquals(command.getClass(), CheckOutBookCommand.class);
    }

    @Test
    void testForInvalidCommand() {
        Command command = this.commandFactory.getCommand("");
        assertEquals(command.getClass(), InvalidCommand.class);
    }

    @Test
    void testForListMoviesCommand() {
        Command command = this.commandFactory.getCommand("list of movies");
        assertEquals(command.getClass(), ListMoviesCommand.class);
    }

    @Test
    void testForCheckOutMovieCommand() {
        Command command = this.commandFactory.getCommand("Check out Movie");
        assertEquals(command.getClass(), CheckOutMovieCommand.class);
    }

    @Test
    void testForReturnMovieCommand() {
        Command command = this.commandFactory.getCommand("Return Movie");
        assertEquals(command.getClass(), ReturnMovieCommand.class);
    }

    @Test
    void testForLoginCommand() {
        Command command = this.commandFactory.getCommand("Login");
        assertEquals(command.getClass(), LoginCommand.class);
    }

    @Test
    void testForDisplayUserInformationCommand() {
        Command command = this.commandFactory.getCommand("Display User Information");
        assertEquals(command.getClass(), DisplayUserInformationCommand.class);
    }

    @Test
    void testForLogOutCommand() {
        Command command = this.commandFactory.getCommand("Logout");
        assertEquals(command.getClass(), LogOutCommand.class);
    }

}