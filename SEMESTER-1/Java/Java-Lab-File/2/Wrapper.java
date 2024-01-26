public class Wrapper{

    public static void main(String[] args) {
        // Autoboxing: Converting primitive to wrapper class
        int primitiveInt = 42;
        Integer wrappedInt = Integer.valueOf(primitiveInt); // Autoboxing

        // Unboxing: Converting wrapper class to primitive
        int unboxedInt = wrappedInt.intValue(); // Unboxing

        System.out.println("Original primitive int: " + primitiveInt);
        System.out.println("Wrapped Integer: " + wrappedInt);
        System.out.println("Unboxed int: " + unboxedInt);

        // Typecasting between wrapper classes
        Double doubleValue = 3.14;

        // Correct way: Using explicit conversion
        Integer integerValue = doubleValue.intValue(); // Converting double to int

        System.out.println("Original Double value: " + doubleValue);
        System.out.println("Integer value after typecasting: " + integerValue);
    

        // Autoboxing and unboxing with arithmetic operations impilcit
        Integer a = 5; // Autoboxing
        Integer b = 10; // Autoboxing

        int sum = a + b; // Unboxing, addition, and autoboxing

        System.out.println("Sum of a and b: " + sum);
    }
}
