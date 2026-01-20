import java.util.Arrays;

public class EnumsExample
{
    public static void main(String[] args) {

        /*
        Enums are classes where all instances are known to the compiler.
        They are used for creating types that can only have few possible values.
         */

        enum DayOfTheWeek {
            MONDAY,TUESDAY,WEDNESDAY,THURSDAY
        }

        DayOfTheWeek someDay = DayOfTheWeek.MONDAY;

       String day =  switch (someDay)
       {
            case MONDAY -> "Start";
            case TUESDAY -> "2nd day";
            case WEDNESDAY -> "3rd day";
            case THURSDAY -> "4th day";
        };
        System.out.println(day);

        System.out.println(DayOfTheWeek.MONDAY.ordinal());
        System.out.println(DayOfTheWeek.THURSDAY.name());
        System.out.println(Arrays.toString(DayOfTheWeek.values())); 


    }
}