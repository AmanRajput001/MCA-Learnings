/**
 1. "Collection" Interface:
        -> Collection is an interface in Java that is part of the Java Collections Framework, which provides a set of classes 
           and interfaces for representing and manipulating collections of objects.
        -> It is the root interface of the Java Collections Framework hierarchy.
        -> Classes that implement the Collection interface represent a group of objects, known as elements, 
           and provide a set of methods for manipulating these elements.
        -> Examples of classes that implement the Collection interface include List, Set, and Queue.
  ----------------------------------------------------------------------------------------------------
 2. "Collections" Class:
        -> On the other hand, the Collections class is a utility class in Java that provides various static methods for working with collections.
        -> It contains methods like sort, reverse, shuffle, etc., 
           that can be used to perform operations on collections or manipulate them in different ways.
        -> It is not an interface like Collection but a helper class with static utility methods.
 */

import java.util.*;

class Person{
    String name;
    int age;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void output(){
        System.out.println("Name : " + name + " | " + "Age: " + age);
    } 
}

public class collectionAndCollections {

    public static void main(String [] args){
        Set<Person> hs = new HashSet<>();  //collection

        hs.add(new Person(21, "Aman"));
        
        hs.add(new Person(22, "Ram"));
        
        hs.add(new Person(22, "Ram"));
        
        hs.add(new Person(12, "Vishal"));
    }
}
