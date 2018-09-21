package biblioteca.view;
import java.util.Scanner;

//Takes input from user
public  class InputDriver {

    public String readInput() {
        Scanner input=new Scanner(System.in);
        return input.next();
    }
}
