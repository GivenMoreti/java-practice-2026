package Java8.Lambda;

public class CalculatorLambdaExample
{
    public static void main(String[] args) {
        System.out.println("hello world");

        Calculator add = ((a, b) -> a + b);
        System.out.println(add.calculate(2,3));

        Calculator multiply = (a, b)-> a * b;
        System.out.println(multiply.calculate(2,3));

        Calculator minus = (a,b) -> a - b;
         System.out.println(minus.calculate(2,3));

    }


}

interface Calculator{
    int calculate (int a, int b);
}