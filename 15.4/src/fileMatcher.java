import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class fileMatcher {
    private static Scanner scannerA;
    private static Scanner scannerB;
    private static Formatter output;
    private static Formatter output2;
    private static int[] accNum;
    private static int[] trAccNum;
    private static String[] fName;
    private static String[] lName;
    private static double[] accBal;
    private static double[] transAmount;
    private static int lines = 0;
    private static int lines2 = 0;

    public static void openAccountFile() {
        Path path = Paths.get("oldmast.txt");

        try {
            scannerA = new Scanner(path);
            lines = (int) Files.lines(path).count();
            accNum = new int[lines];
            fName = new String[lines];
            lName = new String[lines];
            accBal = new double[lines];
        } catch (IOException e) {
            System.exit(1);
        }
    }

    public static void openTransactionRecordFile() {
        Path path = Paths.get("trans.txt");
        try {
            scannerB = new Scanner(path);
            lines2 = (int) Files.lines(path).count();
            trAccNum = new int[lines2];
            transAmount = new double[lines2];
        } catch (IOException e) {
            System.exit(1);
        }
    }

    public static void readAccountRecords() {
        try {
            while(scannerA.hasNext()) {
                for (int i = 0; i < lines; i++) {
                    accNum[i] = scannerA.nextInt();
                    fName[i] = scannerA.next() ;
                    lName[i] = scannerA.next();
                    accBal[i] = scannerA.nextDouble();
                }
            }
        } catch (NoSuchElementException | IllegalStateException elementException) {
            elementException.printStackTrace();
        }
    }

    public static void readTrRecords() {
        try {
            while (scannerB.hasNext()) {
                for (int i = 0; i < lines2; i++) {
                    trAccNum[i] = scannerB.nextInt();
                    transAmount[i] = scannerB.nextDouble();
                }
            }
        } catch (NoSuchElementException | IllegalStateException elementException) {
            elementException.printStackTrace();
        }
    }

    public static void compare() {
        try {
            output = new Formatter("newmast.txt");
            output2 = new Formatter("log.txt");

            if(lines == lines2) {
                for (int i = 0; i < lines; i++) {
                    for (int j = 0; j < lines2; j++) {
                        if (accNum[i] == trAccNum[j]) {
                            output.format("%d %s %.2f%n", accNum[i], fName[i],lName[i], accBal[i] + transAmount[i]);
                            break;
                        } else if (accNum[i] != trAccNum[i]) {
                            output.format("%d %s %.2f%n", accNum[i], fName[i],lName[i], accBal[i]);
                            output2.format("%s %d%n", "Unmatched",trAccNum[i]);
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException | SecurityException e) {
            System.exit(1);
        }
    }

    public static void closeFile() {
        if (output != null) output.close();
        if (output2 != null) output2.close();
        if (scannerA != null) scannerA.close();
        if (scannerB != null) scannerB.close();
    }

    public static void main(String[] args) {
 }
}
