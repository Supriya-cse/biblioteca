package biblioteca.view;

import biblioteca.controller.LibraryManagementSystem;
import org.junit.jupiter.api.Test;

public class ConsoleOutputDriverTest {

    @Test
    void testForPrintingListAsColumns(){
        ConsoleOutputDriver consoleOutputDriver =new ConsoleOutputDriver();
        LibraryManagementSystem libraryManagementSystem= new LibraryManagementSystem(consoleOutputDriver);
    }

}
