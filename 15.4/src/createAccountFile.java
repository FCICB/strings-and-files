import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class createAccountFile {
    private static Formatter output;
    Scanner scanner = new Scanner(System.in);

    public static void openFile() {
        try {
            output = new Formatter("oldmast.txt");
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
    }

    private static void addRecords() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("enter ur accNum : \nenter fName : \nenter Lname : \nenter balance : ");
        while (scanner.hasNext()) {
            try {
                output.format("%d %s %d %d",scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextDouble());
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