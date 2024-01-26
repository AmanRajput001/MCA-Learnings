/**
 * Abstract Class
 *       1)   An abstract class is a class that cannot be implemented on its own.
 *       2)   We use Abstract class as base class for other class.
 *       3)   Abstract class can have abstract methods without any body need to be implemented in sub class (Non abstract class).
 *       4)   Abstract class have concrete methods (Methods that are implemented (With body)) can be overriden in sub classes. 
 *       5)   Abstract class have constructor and we can define our own constructor in abstract class.

   Example:-
        abstract class  class1{
            protected int a = 10;
            public class1(){
                System.out.println("In class1.");
            }
        
            //abstract method
            abstract protected void func1();
            protected void func2(){
                System.out.println("In class1 func2");
            }
        }

        class class2 extends class1{
            //implement func1() must
            protected void func1(){
                System.out.println("In class2 func1");
                func2();
            }
        
            private void func(){
                System.out.println("In class2 func");
                func1();
            }
        
            public static void main(String[] args) {
                class2 obj = new class2();
                obj.func();
            }
        }

        =========================================================
                    <-------------OUTPUT------------->

                                In class1.
                                In class2 func
                                In class2 func1
                                In class1 func2
        ==========================================================
* 
*/