package  DynamicProgramming;

import java.util.Arrays;

public class Callatz {
    public static void main(String[] args) {

        int num = 6;
        generateCallatzNums(num);


    }

    public static void generateCallatzNums(int num){
        System.out.print(num);
        if( num == 1){
            return;     //sequence finished
        }
        System.out.print(", ");

        if(num % 2 == 0)
        {
            generateCallatzNums(num/2);
        }
        else
        {
            generateCallatzNums(num * 3 + 1);
        }

    }
}