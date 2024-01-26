// Outer class
class OuterStatic {
    private static int outerStaticField = 20;

    // Static inner class
    static class StaticInner {
        void display() {
            System.out.println("Value of outerStaticField from StaticInner class: " + outerStaticField);
        }
    }

    // Static method to use the static inner class
    static void useStaticInner() {
        StaticInner staticInnerObj = new StaticInner();
        staticInnerObj.display();
    }
}

class StaticInnerClassesExample {
    public static void main(String[] args) {
        // Using the static inner class directly
        OuterStatic.StaticInner staticInnerObj = new OuterStatic.StaticInner();
        staticInnerObj.display();

        // Using the static inner class through the outer class method
        OuterStatic.useStaticInner();
    }
}
