import java.util.Arrays;
import java.util.Comparator;

// ComplexNumber class representing complex numbers
class ComplexNumber implements Comparable<ComplexNumber> {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Getter methods
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // Method to add two complex numbers
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Method to subtract two complex numbers
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Method to multiply two complex numbers
    public ComplexNumber multiply(ComplexNumber other) {
        double resultReal = this.real * other.real - this.imaginary * other.imaginary;
        double resultImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    // Method to compare complex numbers based on their magnitudes
    @Override
    public int compareTo(ComplexNumber other) {
        double thisMagnitude = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
        double otherMagnitude = Math.sqrt(other.real * other.real + other.imaginary * other.imaginary);
        return Double.compare(thisMagnitude, otherMagnitude);
    }

    // Static method to create an array of complex numbers
    public static ComplexNumber[] createComplexArray(double[] realParts, double[] imaginaryParts) {
        int length = Math.min(realParts.length, imaginaryParts.length);
        ComplexNumber[] complexArray = new ComplexNumber[length];

        for (int i = 0; i < length; i++) {
            complexArray[i] = new ComplexNumber(realParts[i], imaginaryParts[i]);
        }

        return complexArray;
    }

    // Static method to display a complex array
    public static void displayComplexArray(ComplexNumber[] complexArray) {
        for (ComplexNumber complexNumber : complexArray) {
            System.out.println(complexNumber);
        }
    }

    // toString method to represent complex numbers as strings
    @Override
    public String toString() {
        return "(" + real + " + " + imaginary + "i)";
    }
}

// Comparator to compare complex numbers based on their real parts
class RealPartComparator implements Comparator<ComplexNumber> {
    @Override
    public int compare(ComplexNumber o1, ComplexNumber o2) {
        return Double.compare(o1.getReal(), o2.getReal());
    }
}

// Comparator to compare complex numbers based on their imaginary parts
class ImaginaryPartComparator implements Comparator<ComplexNumber> {
    @Override
    public int compare(ComplexNumber o1, ComplexNumber o2) {
        return Double.compare(o1.getImaginary(), o2.getImaginary());
    }
}

public class ComplexArrayArithmetic {
    public static void main(String[] args) {
        // Creating complex arrays
        double[] realParts = {1.0, 2.0, 3.0};
        double[] imaginaryParts = {2.0, 3.0, 4.0};

        ComplexNumber[] complexArray1 = ComplexNumber.createComplexArray(realParts, imaginaryParts);
        ComplexNumber[] complexArray2 = ComplexNumber.createComplexArray(imaginaryParts, realParts);

        // Displaying complex arrays
        System.out.println("Complex Array 1:");
        ComplexNumber.displayComplexArray(complexArray1);

        System.out.println("\nComplex Array 2:");
        ComplexNumber.displayComplexArray(complexArray2);

        // Sorting complex arrays using Comparable
        Arrays.sort(complexArray1);
        Arrays.sort(complexArray2);

        // Displaying sorted complex arrays
        System.out.println("\nSorted Complex Array 1 (by magnitude):");
        ComplexNumber.displayComplexArray(complexArray1);

        System.out.println("\nSorted Complex Array 2 (by magnitude):");
        ComplexNumber.displayComplexArray(complexArray2);

        // Sorting complex arrays using Comparator
        Arrays.sort(complexArray1, new RealPartComparator());
        Arrays.sort(complexArray2, new ImaginaryPartComparator());

        // Displaying complex arrays sorted by real and imaginary parts
        System.out.println("\nSorted Complex Array 1 (by real part):");
        ComplexNumber.displayComplexArray(complexArray1);

        System.out.println("\nSorted Complex Array 2 (by imaginary part):");
        ComplexNumber.displayComplexArray(complexArray2);
    }
}
