// Outer class
class Outer {
    private int outerField = 10;

    // Inner class
    class Inner {
        void display() {
            System.out.println("Value of outerField from Inner class: " + outerField);
        }
    }

    // Method to use the inner class
    void useInner() {
        Inner innerObj = new Inner();
        innerObj.display();
    }
}

class InnerClassesExample {
    public static void main(String[] args) {
        // Creating an instance of the outer class
        Outer outerObj = new Outer();

        // Using the outer class method, which in turn uses the inner class
        outerObj.useInner();
    }
}
