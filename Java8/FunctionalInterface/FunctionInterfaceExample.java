package Java8.FunctionalInterface;

public class FunctionInterfaceExample {
    public static void main(String[] args) {
        // functional interface is an interface containing exactly one abstract method

        //@FunctionalInterface annotation is provided in java 8


        MyFunctionalInterface greet = (user) -> "hello " + user;
        System.out.println(greet.greetUsr("jane"));

    }
}

@FunctionalInterface
interface MyFunctionalInterface {
    String greetUsr(String user);
    //will return error if there is another abstract method
}

