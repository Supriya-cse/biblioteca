package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static biblioteca.common.Constants.SUCCESFUL_LOGOUT;
import static biblioteca.common.Constants.UNSUCCESFUL_LOGOUT;
import static org.mockito.Mockito.when;

public class LogOutCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private LogOutCommand logOutCommand;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(biblioteca.view.ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);

    }

    @DisplayName("should login successfully if user had valid credentials")
    @Test
    void testForSuccessfulLogout() {
        when(input.readInputString()).thenReturn("222-3232").thenReturn("supriya7");
        loginCommand = new LoginCommand();
        loginCommand.perform(output, input, library);
        logOutCommand = new LogOutCommand();
        logOutCommand.perform(output, input, library);
        Mockito.verify(output).print(SUCCESFUL_LOGOUT);
    }

    @DisplayName("should not login if user didn't valid credentials")
    @Test
    void testForUnSuccessfulLogout() {
        when(input.readInputString()).thenReturn("221-3292").thenReturn("supriya7");
        logOutCommand = new LogOutCommand();
        logOutCommand.perform(output, input, library);
        Mockito.verify(output).print(UNSUCCESFUL_LOGOUT);
    }
}
