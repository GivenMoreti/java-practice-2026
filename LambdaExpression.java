import java.util.function.Predicate;

public class LambdaExpression
{
    public static void main(String[] args) {


        /*
            Lambda expressions are a cleaner way to write single-method implementations


         */


        Predicate<String> predicate = (String s) -> {
            return s.length() == 3;
        };
        //OR
        Predicate<String> predicate1 = s -> s.length() == 3;

    }
}