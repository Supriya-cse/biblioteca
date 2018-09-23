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
            return new ReturnBookCommand();
        }
        if (choice.equalsIgnoreCase("List of Movies")) {
            return new ListMoviesCommand();
        }
        if (choice.equalsIgnoreCase("Check out Movie")) {
            return new CheckOutMovieCommand();
        }
        if (choice.equalsIgnoreCase("Return Movie")) {
            return new ReturnMovieCommand();
        }
        return new InvalidCommand();
    }
}
