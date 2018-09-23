package biblioteca.command;

public class CommandFactory {
    public Command getCommand(String choice) {
        if (choice.equalsIgnoreCase("Quit Application")) {
            return new QuitCommand();
        }
        if (choice.equalsIgnoreCase("List of Books")) {
            return new ListBooksCommand();
        }
        if (choice.equalsIgnoreCase("Checkout Book")) {
            return new CheckOutBookCommand();
        }
        if (choice.equalsIgnoreCase("Return Book")) {
            return new ReturnCommand();
        }
        if (choice.equalsIgnoreCase("List of Movies")) {
            return new ListMoviesCommand();
        }
        return new InvalidCommand();
    }
}
