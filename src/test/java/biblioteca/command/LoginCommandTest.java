package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class LoginCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private LoginCommand loginCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(biblioteca.view.ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);

    }

    @DisplayName("should login successfully if user had valid credentials")
    @Test
    void testForSuccessfulLogin() {
        when(input.readInputString()).thenReturn("222-3232").thenReturn("supriya7");
        loginCommand = new LoginCommand();
        loginCommand.perform(output, input, library);
        Mockito.verify(library).authenticate("222-3232", "supriya7");
    }


}