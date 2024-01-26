/**
 * 1.
 * a) WAP to print prime numbers in pairs like 13,31.
 */

import java.util.Scanner;

class PairPrime {
    int n;

    // Method to take user input for the number of pairs.
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of pairs: ");
        while (true) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                sc.next(); // clear the invalid input
            }
        }
        sc.close();
    }

    // Method to check if a number is prime.
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to generate an array of prime number pairs.
    public int[] getPairs() {
        int[] primeNumbers = new int[2 * n];
        int index = 0;
        int num = 13;
        while (index < 2 * n) {
            if (isPrime(num) && isPrime(reverseNumber(num))) {
                primeNumbers[index] = num;
                primeNumbers[index + 1] = reverseNumber(num);
                index += 2;
            }
            num++;
        }
        return primeNumbers;
    }

    // Method to reverse a given number.
    public int reverseNumber(int num) {
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return reverse;
    }

    // Method to display the prime number pairs.
    public void displayArray(int[] primeNumbers) {
        System.out.println("Prime Pairs are: ");
        for (int index = 0; index < primeNumbers.length; index += 2) {
            System.out.println(primeNumbers[index] + ", " + primeNumbers[index + 1]);
        }
    }

    // Main method to execute the program.
    public static void main(String[] args) {
        PairPrime obj = new PairPrime();
        obj.input();
        int[] primeNumbers = obj.getPairs();
        obj.displayArray(primeNumbers);
    }
}
