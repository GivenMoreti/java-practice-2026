package Java8.FunctionalInterface;

import java.util.function.Function;


public class Main{
    public static void main(String[] args) {

        Function<String,Integer> function = String::length;
        System.out.println(function.apply("FooDoo"));


    }
}


class FunctionImpl  implements Function<String,Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
