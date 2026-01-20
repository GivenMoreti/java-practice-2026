package Java8.Lambda;




public class Lambdas{
    public static void main(String[] args) {

        //lambda is an anonymous function
        //functional interfaces - an interface that contains exactly one abstract method
        //it can have any number of default, static methods BUT CAN ONLY CONTAIN ONE ABSTRACT METHOD


        //ABSTRACT METHOD IS METHOD WITHOUT A BODY - JUST SIGNATURE
        //syntax :   () -> {}
        //instead of writing OOP we can just use lambda, NB: shape is a functional interface

        Shape rectangle = () -> System.out.println("drawing rectangle");
        rectangle.draw();

        Shape square = () -> System.out.println("drawing square");
        square.draw();

        //OR
        print(square);
        print(rectangle);

        //OR
        print(() -> System.out.println("drawing square"));
        print(() -> System.out.println("drawing rectangle"));




    }

    public static void print(Shape shape){
        shape.draw();
    }
}

interface Shape {
        void draw();
}

