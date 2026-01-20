package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public  class Main{
    public static void main(String[] args) {


        List<String> fruits = List.of("Banana","Apple","Orange","pear","Avocado","kiwo");

//        for(String fruit: fruits){
//            if( fruit.endsWith("o")){
//                String upperFruit = fruit.toUpperCase();
//                System.out.println(upperFruit);
//            }
//        }

        //using streams to filter
          fruits.stream()
                .filter(f -> f.endsWith("e"))        //condition
                .map(String::toUpperCase)        // Transform each item
                .forEach(System.out::println);   // Do something with each

        fruits.stream()
                .filter(f -> f.endsWith("e"))
                .map(item -> item.toUpperCase())
                .forEach(item -> System.out.println(item));


        List<Integer>numbers = Arrays.asList(1,3,4,2,5,3,2,7,4);
        System.out.println(numbers);

       numbers.stream()
               .filter(num -> num % 2 == 0)
               .map(num -> num.toString())
               .forEach(num -> System.out.println(num));

       List<Integer> nums = numbers
               .stream()
               .filter(num -> num % 3 == 0)
               .collect(Collectors.toList());

        System.out.println(nums);

        //USING STREAMS TO MAP
        //Double each number
        List<Integer> numsDoubled = numbers
                .stream()
                .map(n -> n * 2)
                .toList();
        System.out.println(numsDoubled);

        //2. Sorted
        List<Integer> sortedNums = numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNums);

        //Reduce - add or combine items
        int sum = numbers
                .stream()
                .reduce(0, (a,b) -> a + b);

        // with method reference
        int sum2 = numbers
                .stream()
                .reduce(0,Integer::sum);

        System.out.println(sum);
        System.out.println(sum2);


        //take the first n items
        List<Integer> firstThree = numbers
                .stream()
                .limit(3)
                .toList();

        System.out.println(firstThree);

        long count = numbers
                .stream()
                .count();

        System.out.println(count);

        //print numbers greater than 3
         numbers
                .stream()
                .filter(num -> num > 3)
                .forEach(System.out::println);

        long numsGreaterThanThree =  numbers
                .stream()
                .filter(n -> n > 3)
//                .distinct()
                .count();
        System.out.println("------");
        System.out.println(numsGreaterThanThree);





//        Stream<String> strm = fruits.stream()


//        System.out.println(strm);
        List<Student> students = List.of(
                new Student("kim",20,"Math"),
                new Student("Jack",19,"Physics"),
                new Student("kane",54,"Math"),
                new Student("Maro",8,"Physics")

        );

        //average grade of math students
    double mathAve = students.stream()
                .filter(s -> s.subject.equals("Math"))
                .mapToDouble(s -> s.marks)
                .average()
                 .orElse(0);

    //if I have orElse clause, leave the optional double type
    //add the sum of the first 1000 numbers

        System.out.println(mathAve);


        int n = 3;
        int total = 0;

        for(int i = 1; i <= n; i++)
        {
            total +=i;
        }
        System.out.println(total);

        int firstThousand = sumOfFirstNNums(3);
        System.out.println(firstThousand);



        //summing with steams
        System.out.println(sumOfFirstNNums(3));

        System.out.println(sumOfFirstNNumsThreaded(1000000));
        System.out.println(sumOfFirstNNumsUsingAccumulator(1000000));

    }



    //using stream.iterate
    public static int sumOfFirstNNums2(int n) {
        return Stream
                .iterate(1, i -> i + 1)
                .limit(n)
                .reduce(0, Integer::sum);
    }

    //using stream.rangeClosed
    public static int sumOfFirstNNums(int n){
        return IntStream
                .rangeClosed(1,n)
                .sum();
    }

    //using range-which is not inclusive
    public static int sumOfFirstNNums3(int n){
        return IntStream
                .range(1,n +1)
                .sum();
    }

    //Using math formula
    public static int sumOfFirstNNums4(int n){
        return n * (n + 1)/2;

    }

    //with multi-threading
    public static int sumOfFirstNNumsThreaded(int n){
        //parallel processing - good for large n
        return IntStream
                .rangeClosed(1,n)
                .parallel()
                .sum();
    }

    public static int sumOfFirstNNumsUsingAccumulator(int n){
        return IntStream
                .rangeClosed(1,n)
                .reduce(0,(accumulator,current) -> accumulator + current);
    }

    /*
    which can also be written using method reference as:
      public static int sumOfFirstNNumsUsingAccumulator(int n){
        return IntStream.rangeClosed(1,n).reduce(0,(Integer::sum);
    }

     */


}

class Student {
    public String name;
    public int marks;
    public String subject;

    public Student(String name, int marks, String subject){
        this.marks = marks;
        this.name = name;
        this.subject = subject;
    }

    public String toString(){
        return this.name + " " + this.subject + " " + this.marks;
    }


}