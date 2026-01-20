package Java8.FunctionalInterface;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class ConsumerEx{
    public static void main(String[] args) {

        Consumer<String> consumer = new ConsumerImp();
        consumer.accept("Hello consumer example");


        Consumer<String> consumer2 = (s) -> System.out.println(s);
        //        Consumer<String> consumer2 = System.out::println;     //using method reference
        consumer2.accept("Hello consumer example 2");

    }
}


class ConsumerImp implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
