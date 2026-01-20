import java.awt.*;
import java.util.Arrays;

public class ArraysTut{

    public static void main(String[] args) {
        System.out.println("arrays");

        /*
            An array is a container object that holds a fixed number of values of a single type.
            The length of an array is established when the array is created. After creation, its length is fixed.
            elements and indexes
            arr[i] = element
         */

        int[] nums;
        nums = new int[3];
        nums[0] = 34;

        for(int n: nums){
            System.out.println(n);
        }
        System.out.println(Arrays.toString(nums));
        //if an arr is an integer it allocates zeroes to unassigned mem locations
        // if string its nulls to empty elements

        String [] names = new String[3];
        names[0] = "kim";

        System.out.println(Arrays.toString(names));
        printAll(names);

        double [] dblArr = new double[3];
        dblArr[0] = 33.4d;

        System.out.println(Arrays.toString(dblArr));
        // double assigns a floating point values to empty elements



        int [] numsArr = {34,3,41};
        System.out.println(numsArr.length);
        numsArr[1] = 11;



        try{
//            for(int i: numsArr){
//                System.out.println(i);
//            }

            for(int i = 0;i < numsArr.length;i++){
                System.out.println(numsArr[i]);
            }
        }catch(IndexOutOfBoundsException e){
           throw new IndexOutOfBoundsException("out of bounds");
        }


        int[] original  = {1,2,3,5};
        int[] copy = new int[original.length];


        for(int i = 0; i< original.length;i++){
            copy[i] = original[i];
        }

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copy: " + Arrays.toString(copy));

        /*
            Sorting an array into ascending order.
            This can be done either sequentially, using the sort() method, or concurrently,
            using the parallelSort() method introduced in Java SE 8.
            Parallel sorting of large arrays on multiprocessor systems is faster than sequential array sorting.

         */


    }

    public static void printAll(String[] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    //array copy method

    String[] foos = {"somefoo","anotherfoo","againFoo"};

    String[] copies = new String[3];








}