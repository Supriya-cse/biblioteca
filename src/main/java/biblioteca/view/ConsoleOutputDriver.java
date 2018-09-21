package biblioteca.view;

import java.util.Arrays;
import java.util.List;

public class ConsoleOutputDriver implements OutputDriver {
    @Override
    public void print(Object messageToPrint) {
        System.out.println(messageToPrint);
    }

    @Override
    public void printListAsColumns(String string){
        List<String> textToBeFormated= Arrays.asList(string.split(","));
        int columnTerminator=0;
        for (String textToPrint:textToBeFormated) {
            System.out.printf("%-30s ",textToPrint);
            columnTerminator++;
            if(columnTerminator==textToBeFormated.size()){
                System.out.println();
            }
        }

    }
}
