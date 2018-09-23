package biblioteca.command;

public class CommandFactory {
    public Command getCommand(String choice) {
        if(choice.equalsIgnoreCase("Quit Application")) {
            return new QuitCommand();
        }
        if(choice.equalsIgnoreCase("List of Books")) {
            return new  ListBooksCommand();
        }
        if(choice.equalsIgnoreCase("Checkout Book")) {
            return new CheckOutCommand();
        }
        if(choice.equalsIgnoreCase("Return Book")) {
            return new ReturnCommand();
        }
        return new InvalidCommand();
    }
}
