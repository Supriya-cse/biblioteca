package biblioteca.command;
import biblioteca.command.InvalidCommand;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

 class InvalidCommandTest {

    private ConsoleOutputDriver output;
    private InvalidCommand invalidCommand;
    private InputDriver input;
    private Library library;

    @BeforeEach
    void init() {
        invalidCommand=new InvalidCommand();
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);
    }

    @DisplayName("should display select valid option when invalid command is given")
    @Test
    void testForInvalidOption(){
        String selectValidOption = "Select a valid option!";
        invalidCommand.perform(output,input,library);
        Mockito.verify(output).print(selectValidOption);
    }

}
