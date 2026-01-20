public class MultiDimenArrays{
    public static void main(String[] args) {
       //int[rows][cols] arr;

        int[][] coords = {
                //0 1 2
                {1,2,3}, //0
                {4,5,9}  //1
        };

//        coords[0][0] = 2;
        System.out.println(coords[0].length);   //length of first arr i.e. at index 0.
        System.out.println(coords[1].length);

        //print the items

        for(int i = 0;i < coords.length;i++){
            for(int j = 0 ; j < coords[i].length;j++){
                System.out.print(coords[i][j] + " ");

            }
            System.out.println();
        }

        //add all the items

        int sum = 0;
        for(int i = 0;i < coords.length;i++){
            for(int j = 0 ; j< coords[i].length;j++){
              sum+= coords[i][j];

            }
        }
        System.out.println("sum = "+sum);
        //find an element 5

        for(int i = 0;i < coords.length;i++){
            for(int j = 0 ; j< coords[i].length;j++){
                if(coords[i][j] == 5){
                    System.out.println(i + " " +j);
                }

            }
        }
        //find max/min
        int max = 0;
        for(int i = 0;i < coords.length;i++){
            for(int j = 0 ; j< coords[i].length;j++){

                max = coords[0][0];
                if(coords[i][j] > max){
                    max = coords[i][j];
                }

            }
        }
        System.out.println("max = "+ max);


        //swap two variables

        int var1 = 10;
        int var2 =3;

        int temp = var1;
        var1 = var2;        //assign var 1
        var2 = temp;

        System.out.println("var 1: " + var1); //3
        System.out.println("var 2: " + var2); //10


        String[] arr = {"one","two","3","5"};
        String[] arr1 = new String[4];


        System.arraycopy(arr, 1, arr1, 2, 2);

        for(String a:arr1){
            System.out.println(a);
        }



    }


}