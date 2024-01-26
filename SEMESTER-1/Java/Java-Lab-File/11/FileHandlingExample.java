/**
 * Creating  Java   Applications   for   implementing   File   Handling   for
 * reading/writing data from persistent storage and vice-versa
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an operation:");
        System.out.println("1. Write to File");
        System.out.println("2. Read from File");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                writeToTextFile();
                break;
            case 2:
                readFromTextFile();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }

        scanner.close();
    }

    private static void writeToTextFile() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the file name to write to: ");
            String fileName = scanner.nextLine();

            FileWriter fileWriter = new FileWriter(fileName);

            System.out.println("Enter text to write to the file (type 'exit' to finish):");
            while (true) {
                String line = scanner.nextLine();
                if (line.equals("exit")) {
                    break;
                }
                fileWriter.write(line + "\n");
            }

            fileWriter.close();
            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromTextFile() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the file name to read from: ");
            String fileName = scanner.nextLine();

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("Contents of the file:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
