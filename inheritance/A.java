package inheritance;


/*
    One significant difference between classes and interfaces is that classes can have fields
     whereas interfaces cannot.
     Class encapsulates its state and behaviour
     Java programming language supports multiple inheritance of type, which is the ability of a class to implement more than one interface. An object can have multiple types:
     the type of its own class and the types of all the interfaces that the class implements.
 */

public class A{
    public static void main(String[] args) {
        System.out.println("hello world");

        Bicycle b1 = new Bicycle();
        Bicycle b2 = new MountainBike();
        MountainBike mb = (MountainBike) b2;

    }

}

class Bicycle extends Object{
    public static void drive(){
        System.out.println("driving Bicycle");
    }
}

class MountainBike extends Bicycle{
    public static void drive(){
        System.out.println("driving mountain bike");
    }
}