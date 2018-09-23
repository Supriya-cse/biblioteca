package biblioteca.view;

import java.util.Scanner;

//Takes input from user
public class InputDriver {

    public int readInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public String readInputString() {
        Scanner inputString = new Scanner(System.in);
        return inputString.nextLine();
    }

}
