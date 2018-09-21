package biblioteca.view;

public class ConsoleOutputDriver implements OutputDriver {
    @Override
    public void print(Object message) {
        System.out.println(message);
    }
}
