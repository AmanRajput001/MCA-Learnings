/**
 * 1.b) Write a program to validate email address
 * • @ should be before .
 * • alphabet or digit should be before and after @
 * • alphabet should be before . and 3 alphabets after.
 */

import java.util.Scanner;

public class ValidateEmail {
    char[] email;

    // Method to take user input for the email address.
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Email: ");
        String inputEmail = sc.nextLine();
        sc.close();

        email = inputEmail.toCharArray();
    }

    // Method to check the validity of the email address based on specified criteria.
    public boolean checkEmail() {
        boolean atTheRate = false, flag = true;
        boolean dot = false;
        int emailLength = email.length;

        for (int i = 0; i < emailLength; i++) {
            if (i == 0 && email[i] == '@') {
                flag = false;
                break;
            } else if (i != 0 && email[i] == '@') {
                atTheRate = true;

                if (i + 1 < emailLength) {
                    if (!((Character.isDigit(email[i - 1]) || Character.isLetter(email[i - 1]))
                            && (Character.isDigit(email[i + 1]) || Character.isLetter(email[i + 1])))) {
                        flag = false;
                        break;
                    }
                }
            }

            if (email[i] == '.' && atTheRate == false) {
                dot = true;
                flag = false;
                break;
            } else if ((email[i] == '.' && atTheRate == true)) {
                dot = true;
                if (!((Character.isDigit(email[i - 1]) || Character.isLetter(email[i - 1]))
                        && (i + 3 < emailLength && Character.isLetter(email[i + 1]) && Character.isLetter(email[i + 2])
                                && Character.isLetter(email[i + 3])))) {
                    flag = false;
                    break;
                }
            }
        }

        return flag && dot && atTheRate;
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        ValidateEmail ve = new ValidateEmail();

        ve.input();
        if (ve.checkEmail()) {
            System.out.println("Valid.");
        } else {
            System.out.println("Invalid.");
        }
    }
}
