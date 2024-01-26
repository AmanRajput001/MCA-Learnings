import java.util.Scanner;

// Custom exception for divide by zero
class CustomDivideByZeroException extends Exception {
    public CustomDivideByZeroException(String message) {
        super(message);
    }
}

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter a denominator: ");
            int denominator = scanner.nextInt();

            // Division operation that may cause an exception
            int result = divide(numerator, denominator);

            // Displaying the result
            System.out.println("Result of division: " + result);
        } catch (CustomDivideByZeroException e) {
            // Catch block for handling CustomDivideByZeroException
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Catch block for handling other exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Finally block to close resources or perform cleanup (always executed)
            System.out.println("Finally block executed");
            scanner.close();
        }
    }

    // Method to perform division with throws clause
    private static int divide(int numerator, int denominator) throws CustomDivideByZeroException {
        if (denominator == 0) {
            // Throw the custom exception when attempting to divide by zero
            throw new CustomDivideByZeroException("Division by zero is not allowed");
        }
        return numerator / denominator;
    }
}