/**
 * In Java, the final keyword is used to denote that a variable, method, or class 
 * cannot be further modified, overridden, or extended, respectively.
 * 
 * Final keyword used for making:-
 * 
 * 1) final method:- method that cannot be overriden.
 *    
 *    Example:-
            class Parent {
                final void display() {
                    System.out.println("This method cannot be overridden.");
                }
            }

            class Child extends Parent {
                //void display() { } // Error: Cannot override the final method from Parent
            }

      Output:-
                ===========================================================
                   display() in Child cannot override display() in Parent
                    void display() { }
                           ^
                    overridden method is final
                    1 error                    
                ===========================================================
    
    2) final class:- final class is a class that cannot be subclassed cannot be inherited.

       Example:-
            final class FinalClass {
                // Class content
            }
            
            class Subclass extends FinalClass { }
            // Error: Cannot subclass a final class

       Output:-
                ================================================================== 
                        error: cannot inherit from final FinalClass
                                    class Subclass extends FinalClass { }
                                                           ^
                        1 error                 
                ==================================================================

    3) final method:- final method is a method which cannot be further modified.

       Example:-      
            class Class1{
                final int a = 10;
                public static void main(String [] args){
                    Class1 obj = new Class1();
                    //obj.a = 11; 
                    // Error: Cannot assign a value to a final variable
                }
            }

       Output:-
                ================================================================== 
                            error: cannot assign a value to final variable a
                                    obj.a = 11; 
                                       ^
                            1 error
                
                ==================================================================

    4) final parameter:- When applied to method parameters, the final keyword indicates 
                         that the parameter's value cannot be changed within the method.
       Example:- 
            void process(final int value) {
                // value cannot be reassigned within this method
            }

*/



