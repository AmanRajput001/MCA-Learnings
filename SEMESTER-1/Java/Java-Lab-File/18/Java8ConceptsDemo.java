import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Define a functional interface for a simple operation
@FunctionalInterface
interface Operation {
    int perform(int a, int b);
}

public class Java8ConceptsDemo {

    public static void main(String[] args) {
        // Example 1: Lambda expressions
        Operation addition = (a, b) -> a + b;
        Operation subtraction = (a, b) -> a - b;

        System.out.println("Addition: " + operate(10, 5, addition));
        System.out.println("Subtraction: " + operate(10, 5, subtraction));

        // Example 2: Stream API
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use stream to filter even numbers, double them, and collect the result in a new list
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println("Filtered and Doubled List: " + result);

        // Example 3: Method references
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Use method reference to print each name
        names.forEach(System.out::println);
    }

    // Method that takes an operation as a parameter and performs it on two numbers
    private static int operate(int a, int b, Operation operation) {
        return operation.perform(a, b);
    }
}
