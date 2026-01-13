import java.math.BigDecimal;

public class Variables{
    public static void main(String[] args) {


        /*

            types of variables
            instance: stores their states in non-static fields.
                -values are unique to each instance of a class

            class variables:
                - static fields.
                -  this tells the compiler that there is exactly one copy of this variable in existence,
                regardless of how many times the class has been instantiated.
                - static int final someNum= 3  indicates that the variable will not be reassigned or change

            Local variables:
                - declared inside methods.
            paramaters:
                - declared inside the functions
                - require args

                public static int final SOME_VALUE = 100;


         */
        System.out.println("variables");


        /*
            java is statically typed.
            statically typed - means all variables must be declared  by type and name before they can be used.

                   PRIMITIVE TYPES

                   byte =  8 bit, range = 128 to -128
                   short = 16 bit , range -32768 to 32768
                   int = 32 bit -2^31
                   long = 64 bit -2^63
                   float = 32 bit
                   BigDecimal = used for money
                   double = 64 bit
                   boolean = true/false
                   char = 16 bit

         */

        int num = 1000000000;
        byte valueIs = 127;
        valueIs++;
        System.out.println(valueIs); //-128

        short shortNum= 3300;
        char character = 'W';

        double doubleNum = 23.45d;
        System.out.println(doubleNum);


        float foatNum = 33.2f;
        System.out.println(foatNum);

        BigDecimal someMoney = BigDecimal.valueOf(4500);
        System.out.println(someMoney);


    }
}