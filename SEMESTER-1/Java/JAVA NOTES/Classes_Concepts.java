/*
 * Class:- Logical contruct on whihc entire java depends.
 *         1. It define nature and shape of an Object.
 *         2. Class is an blue print of an object.
 *         "A class is a way to bind an entity (instance variable) and methods into a single unit.""
 * 
 * Object:- An object is an instance of a class.
 * Methods:- It contain code (Logics) and determine how class data can be used.
 * Members:- Methods and instance variable in a class called members of class.
 * 
 * """"""""""""""""""""""""""""""""""""""""""""""""""""""""
 *   When an class is created no memory is allocated, 
 *   memory is allocated when an obejct is created.
 * """"""""""""""""""""""""""""""""""""""""""""""""""""""""
 * To create an Object in java we are using keyword named as "new". (dynamic memory allocation).
 * 
 * Reference Variable:-
 *  In Java, a reference variable is a variable that holds the memory address of an object. 
 *  It doesn't actually store the object itself but points to the location in memory where the object is stored.
 * 
 * Example:-
 *          class A{
 *          }
 *          
 *          class Main{
 *           public static void main(String [] args){
 *               A obj; //---> This means we are making obj as reference variable of class
 *               new A(); //---> This means we are making object of class A but 
 *                        //     not assigning its memory value to any reference variable.
 *               A obj1 = new A(); // This means we are making object of class A,
 *                                 // Assigning its memory value to reference variable of class A obj1.
 *           }
 *          }
 */

/*Class Access Modifiers:- Only two types:- 1. public
 *                                          2. default (private)
 * public:- The class is accessible by any other class anywhere, regardless of the package they belong to.
 * default (private):- (when nothing mention means deafult)  The class is only accessiible in same package.
 * 
 * Class Memembers Access Modifiers:- Only Fours types: 1. public
 *                                                      2. default (private)
 *                                                      3. private
 *                                                      4. protected
 * 
 * public:- The class members can be accessed anywhere with help of object in that class.
 *          They can be accessed by any other class in the same package or from any other package. 
 *          Access is not limited to the use of objects; you can also access public static members 
 *          using the class name directly.
 * default:- (when nothing mention means deafult) The class members can be accessed only with in the class 
 *           (and other class also accessed which are in same package), not in any other class in different pacakge.
 * private:- The class members can be accessed only with in the class, not in any other class in same package also.
 * protected:- The protected declared members can be accessed by the sub class of particular class.
 *             In any package, any pacakge class can be imported then we can extends it and use its members. 
   
   Eample:-
        class A{ //default Access modifier
        
            int a; //private data member
            public int b; //public data member
        
            public void callMe1() // public Method
            {
                a = 10;
                b=100;
                System.out.println("\nIn A PUBLIC.");
                System.out.println(a + "  " + b);
            }
        
            void callMe2() // default Method
            {
                a = 10;
                b=100;
                System.out.println("\nIn A DEFAULT.");
                System.out.println(a + "  " + b);
            }
        
            protected void callMe3() // Protected Method
            {
                a = 10;
                b=100;
                System.out.println("\nIn A PROTECTED.");    
                System.out.println(a + "  " + b);
            }
        
            private void callMe4() // Private Method
            {
                a = 10;
                b=100;
                System.out.println("\nIn A PRIVATE.");
                System.out.println(a + "  " + b);
            
            }
        }

        public class Classes_Concepts extends A // "extends" use for inheritance 
        {
            public static void main(String []args){
                A obj = new A();
            
                obj.callMe1();
                obj.callMe2();
                obj.callMe3();
                //obj.callMe4(); //we cannot access as callMe4() is Private, 
                                 //if we this Compile time error:- callMe4() has private access in A 
            }
        }

        """"""""""OUTPUT""""""""""
                In A PUBLIC.
                10  100

                In A DEFAULT.
                10  100

                In A PROTECTED.
                10  100
         """""""""""""""""""""""""      
*/

/*
 * Inheritance:-
 * It is the concept in ythe programming languages like java which allow one class (sub-class)
 * to inherit the feature or mmebers of other class (super class).
 * 
 * we do inheritance in java with the help of key word "extends".
 * 
 * Type pf inheritance in java:-
 *              1. Herarichal Inheritance (A parent class having multiple childs)
 *              2. Single Inheritance (One parent - One child)
 *              3. Multilevel Inheritance (parent class its sub class then its sub class )
 * 
 * "In java there is no multiple inheritance as it was there in c++."
 * 
 * Example:-
 *      Class A{} // super class
 *      
 *      Class B extends A //it is Single Inheritance //sub class for A and super class for C
 *      {}
 *      
 *      class C extends B //it is Multilevel Inheritance //sub class for B
 *      {}
 *      
 *      class D extends A //it is Herarichal Inheritance
 *      {}
 *      
 *      "Whatever data member will be inherited in sub class that data member Access Modifier remian same."
 *      
 * Keywords like super Vs this:-
 * "super" keyword help to the  super class member.
 * "this"  keyword help to the its on class member.
 * 
 * "super keyword can also be used to call the super class constructor in the sub class constructor." 
 *      
 *Example:-

 class A{
    protected int a = 9; 
    A(){
        System.out.println("In class A");
    }

    public void function(){
        System.out.println("In class A Function.");
        System.out.println(a + "a of class A");
    }
 }

 class B extends A{
    int a = 11;
    B(){
        super(); //we call super constructor;
        System.out.println("In class B");
    }

    @Override
    public void function(){                
        System.out.println("In class B Function.");
        System.out.println(this.a + "a of class b");
        a = 19;
        System.out.println(super.a + "a of class A");
        System.out.println(this.a + "a of class b");
        super.a = 100;        
        System.out.println(super.a + "a of class A");
    }

    public static void main(String [] args){
        A a;
        a = new B();
        a.function();// call function of class of B
    }
 }

=========================================================
            <-------------OUTPUT------------->

                        In class A
                        In class B
                        In class B Function.
                        11a of class b
                        9a of class A
                        19a of class b
                        100a of class A
==========================================================
 * 
 */