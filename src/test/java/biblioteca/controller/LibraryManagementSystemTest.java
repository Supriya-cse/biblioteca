package biblioteca.controller;

import biblioteca.command.Command;
import biblioteca.command.CommandFactory;
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
    private InputDriver inputDriver;
    private CommandFactory commandFactory;
    private Library library;
    private Command aCommand;
    private Command anotherCommand;


    @BeforeEach
    void init() {
        consoleOutputDriver = Mockito.mock(ConsoleOutputDriver.class);
        inputDriver = Mockito.mock(InputDriver.class);
        library = Mockito.mock(Library.class);
        commandFactory = Mockito.mock(CommandFactory.class);
        aCommand = mock(Command.class);
        anotherCommand = mock(Command.class);
        when(inputDriver.readInput()).thenReturn(1).thenReturn(0);
        when(commandFactory.getCommand(any())).thenReturn(aCommand).thenReturn(anotherCommand);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(consoleOutputDriver, inputDriver, library, commandFactory);
        libraryManagementSystem.start();
    }

    @Test
    void testForWelcomeMessage() {
        Mockito.verify(consoleOutputDriver).print("Welcome to the Bangalore Library");
    }

    @Test
    void shouldAskCommandFactoryToGetCommandBasedOnChoice() {
        Mockito.verify(commandFactory, times(2)).getCommand(any());
    }


    @Test
    void testForExecutingProperCommandBasedOnUserChoice() {
        Mockito.verify(aCommand).perform(consoleOutputDriver, inputDriver, library);
        Mockito.verify(anotherCommand).perform(consoleOutputDriver, inputDriver, library);
    }

}