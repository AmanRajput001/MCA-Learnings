
/**
 * File Handling:- File handling in Java is the process of working with files stored on a computer's file system. 
 *                 Java provides several classes and methods in the java.io package to perform file operations
    
class FileExample {

    public void fileOpen(){
        String file2 = "example.txt";
        String file1 = "Nested_class.java";

        File f =  new File(file1);
        File w =  new File(file2);

        boolean exist1 = f.exists();
        boolean exist2 = w.exists();

        if(exist1 && exist2 ){
            System.out.println("File Handling...");
            try{
                operation_lineByLine(file1,file2);
                operation_CharacterByCharacter(file1,file2);
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("File not exists...");
        }

    }

    public void operation_lineByLine(String file1, String file2) throws IOException{

        BufferedReader file_input = new BufferedReader(new FileReader(file1));
        BufferedWriter file_Output = new BufferedWriter(new FileWriter(file2, true)); // (file2, true) true means open file  append mode


        String line;

        while((line = file_input.readLine()) != null){
            System.out.println(line);
            file_Output.write(line);
            file_Output.newLine();// add newLine
            file_Output.flush(); // after each write operation, 
                                // you ensure that the data is immediately written to the file and not held in the buffer.
        }
     System.out.println("File copied successfully.");

    }

    public void operation_CharacterByCharacter(String file1, String file2) throws IOException{

        BufferedReader file_input = new BufferedReader(new FileReader(file1));
        BufferedWriter file_Output = new BufferedWriter(new FileWriter(file2, true)); // (file2, true) true means open file  append mode


        int character;

        while((character = file_input.read()) != -1){

            System.out.println((char)character);
            file_Output.write((char)character);
            file_Output.flush(); // after each write operation, 
                                // you ensure that the data is immediately written to the file and not held in the buffer.
        }
     System.out.println("File copied successfully.");

    }
}

*/

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Bank {
    int accountNumber, atmCardNumber, atmPin;
    String accountHolderName;

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Account Number: ");
        accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Account Holder Name: ");
        accountHolderName = sc.nextLine();

        System.out.print("ATM Card Number: ");
        atmCardNumber = sc.nextInt();

        System.out.print("ATM Pin: ");
        atmPin = sc.nextInt();
    }

    public void FileHandling() {
        String fileName = "BankAccounts.txt";

        try {
            if ((new File(fileName)).exists()) {
                System.out.println("Saving Details");

                BufferedWriter output = new BufferedWriter(new FileWriter(fileName));

                output.write("Account Number: " + accountNumber);
                output.write("Account Holder Name: " + accountHolderName);
                output.write("ATM Card Number: " + atmCardNumber);
                output.write("ATM Pin: " + atmPin);

                output.newLine();
                output.flush();

            }
        } catch (IOException e) {
            // exception
        }
    }
}

class Example{

    public void FileHandling(){
        try{
            BufferedReader example1 = new BufferedReader(new FileReader("Example1.txt"));            
            BufferedWriter example2 = new BufferedWriter(new FileWriter("Example2.txt"));

            int lines = 0;
            int words = 0;

            String line;
            while((line = example1.readLine()) != null){

                StringTokenizer st = new StringTokenizer(line);

                while(st.hasMoreTokens()){
                    words++;
                    st.nextToken();
                }

                lines++;

                example2.write(line);
                example2.newLine();
                example2.flush();
            }

            System.out.println("No. of lines:- " + lines);
            System.out.println("No. of words:- " + words);
            
        }
        catch(IOException e){
            //--<statement>--
        }

    }
}

public class FileHandling {
    public static void main(String[] args) {
        //Bank b = new Bank();
        //b.input();
        //b.FileHandling();

        Example e = new Example();
        e.FileHandling();
    }

}
