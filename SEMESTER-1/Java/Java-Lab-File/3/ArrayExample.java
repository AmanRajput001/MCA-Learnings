import java.util.Scanner;

public class ArrayExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get array size from user input
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create a single-dimensional array
        int[] singleArray = new int[size];

        // Initialize the single-dimensional array
        initializeArray(singleArray);

        // Display the single-dimensional array
        System.out.println("Single-Dimensional Array:");
        displayArray(singleArray);

        // Get row and column sizes for the multi-dimensional array
        System.out.print("\nEnter the number of rows for the 2D array: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the 2D array: ");
        int columns = scanner.nextInt();

        // Create a multi-dimensional array
        int[][] multiArray = new int[rows][columns];

        // Initialize the multi-dimensional array
        initializeArray(multiArray);

        // Display the multi-dimensional array
        System.out.println("\nMulti-Dimensional Array:");
        displayArray(multiArray);

        // Create a ragged array
        int[][] raggedArray = createRaggedArray();

        // Display the ragged array
        System.out.println("\nRagged Array:");
        displayArray(raggedArray);

        scanner.close();
    }

    // Function to initialize an array
    public static void initializeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2; // Just an example initialization
        }
    }

    // Overloaded function to initialize a 2D array
    public static void initializeArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i + j; // Just an example initialization
            }
        }
    }

    // Function to create and initialize a ragged array
    public static int[][] createRaggedArray() {
        int[][] raggedArray = new int[3][]; // 3 rows with different column sizes

        raggedArray[0] = new int[]{1, 2, 3}; // Row 0 with 3 columns
        raggedArray[1] = new int[]{4, 5};    // Row 1 with 2 columns
        raggedArray[2] = new int[]{6, 7, 8, 9}; // Row 2 with 4 columns

        return raggedArray;
    }

    // Overloaded function to display an array
    public static void displayArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Overloaded function to display a 2D array
    public static void displayArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
