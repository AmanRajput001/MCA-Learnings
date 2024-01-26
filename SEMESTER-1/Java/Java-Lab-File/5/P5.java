// Base class (parent class)
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Single Inheritance: Dog is a subclass of Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Multilevel Inheritance: Poodle is a subclass of Dog
class Poodle extends Dog {
    void groom() {
        System.out.println("Poodle is being groomed");
    }
}

// Multiple Inheritance: Bird is a subclass of Animal and implements the Flyable
// and Swimmable interfaces
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird extends Animal implements Flyable, Swimmable {
    @Override
    void eat() {
        System.out.println("Bird is eating");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }

    @Override
    public void swim() {
        System.out.println("Bird is swimming");
    }
}

// Hierarchical Inheritance: Cat and Lion are subclasses of Animal
class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

class Lion extends Animal {
    void roar() {
        System.out.println("Lion is roaring");
    }
}

// Hybrid Inheritance: Parrot is a subclass of Bird and implements the Talkable
// interface
interface Talkable {
    void talk();
}

class Parrot extends Bird implements Talkable {
    @Override
    public void talk() {
        System.out.println("Parrot is talking");
    }
}

public class P5 {
    public static void main(String[] args) {
        // Single Inheritance
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();

        // Multilevel Inheritance
        Poodle myPoodle = new Poodle();
        myPoodle.eat();
        myPoodle.bark();
        myPoodle.groom();

        // Multiple Inheritance
        Bird myBird = new Bird();
        myBird.eat();
        myBird.fly();
        myBird.swim();

        // Hierarchical Inheritance
        Cat myCat = new Cat();
        myCat.eat();
        myCat.meow();

        Lion myLion = new Lion();
        myLion.eat();
        myLion.roar();

        // Hybrid Inheritance
        Parrot myParrot = new Parrot();
        myParrot.eat();
        myParrot.fly();
        myParrot.talk();
    }
}