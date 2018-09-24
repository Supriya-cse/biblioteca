package biblioteca.controller;

import biblioteca.command.Command;
import biblioteca.command.CommandHelper;
import biblioteca.model.Library;
import biblioteca.view.ConsoleOutputDriver;
import biblioteca.view.InputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {

    private ConsoleOutputDriver consoleOutputDriver;
    private LibraryManagementSystem libraryManagementSystem;
    private InputDriver inputDriver;
    private CommandHelper commandHelper;
    private Library library;


    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        inputDriver = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);
        commandHelper = Mockito.mock(CommandHelper.class);
    }

    @Test
    void testForWelcomeMessage() {
        Command aCommand = mock(Command.class);
        Command anotherCommand = mock(Command.class);
        when(inputDriver.readInput()).thenReturn(1).thenReturn(0);
        when(commandHelper.getCommand(any())).thenReturn(aCommand).thenReturn(anotherCommand);
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library, commandHelper);
        libraryManagementSystem.start();
        Mockito.verify(consoleOutputDriver).print("Welcome to the Bangalore Library");
    }

    @Test
    void shouldAskCommandFactoryToGetCommandBasedOnChoice() {
        Command aCommand = mock(Command.class);
        Command anotherCommand = mock(Command.class);
        when(inputDriver.readInput()).thenReturn(1).thenReturn(0);
        when(commandHelper.getCommand(any())).thenReturn(aCommand).thenReturn(anotherCommand);
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library, commandHelper);
        libraryManagementSystem.start();
        Mockito.verify(commandHelper, times(2)).getCommand(any());
    }


    @Test
    void testForExecutingProperCommandBasedOnUserChoice() {
        Command aCommand = mock(Command.class);
        Command anotherCommand = mock(Command.class);
        when(inputDriver.readInput()).thenReturn(1).thenReturn(0);
        when(commandHelper.getCommand(any())).thenReturn(aCommand).thenReturn(anotherCommand);
        libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library, commandHelper);
        libraryManagementSystem.start();
        Mockito.verify(aCommand).perform(consoleOutputDriver, inputDriver, library);
        Mockito.verify(anotherCommand).perform(consoleOutputDriver, inputDriver, library);
    }

}