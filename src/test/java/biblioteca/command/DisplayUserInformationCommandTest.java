package biblioteca.command;

import biblioteca.model.Library;
import biblioteca.model.LibraryHelper;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DisplayUserInformationCommandTest {

    private ConsoleOutputDriver output;
    private InputDriver input;
    private Library library;
    private LibraryHelper libraryHelper;
    private DisplayUserInformationCommand displayUserInformationCommand;

    @BeforeEach
    void init() {
        output = Mockito.mock(ConsoleOutputDriver.class);
        input = Mockito.mock(InputDriver.class);
        libraryHelper = new LibraryHelper();
        library = new Library(libraryHelper.listOfLibraryItems(), libraryHelper.listOfUser());
        displayUserInformationCommand = new DisplayUserInformationCommand();
    }


    @DisplayName("Should display current user information")
    @Test
    void testForDisplayingUserInformation() {
        displayUserInformationCommand.perform(output, input, library);
        Mockito.verify(output).print(library.currentUserInformation());
    }

}
