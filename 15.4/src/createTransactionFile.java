import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class createTransactionFile {
    private static Formatter output;
    Scanner scanner = new Scanner(System.in);

    public static void openFile() {
        try {
            output = new Formatter("trans.txt");
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
    }

    private static void addRecords() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("enter ur accNum : \nenter trans amount : ");
        while (scanner.hasNext()) {
            try {
                output.format("%s %d %d", scanner.next(), scanner.nextInt(), scanner.nextInt());
            } catch (FormatterClosedException f) {
                System.out.println("error writing to file");
                break;
            } catch (NoSuchElementException e) {
                System.out.println("invalid input format");

            }
            System.out.println("?   ");
        }
    }

    private static void closeFile() {
        if (output != null)
            output.close();
    }

}
