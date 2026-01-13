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
    }

    public static void printAll(String[] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    //array copy method

    String[] foos = {"somefoo","anotherfoo","againFoo"};

    String[] copies = new String[3];
//    System.arraycopy()


    public static int[] copyArr(int[] a){
        int[] temp = new int [a.length];

        System.arraycopy(a, 0, temp, 0, a.length);

        // manual version
//        for(int i = 0;i < a.length;i++ ){
//            temp[i] = a[i];
//        }
        a = temp;
        return a;

    }

}