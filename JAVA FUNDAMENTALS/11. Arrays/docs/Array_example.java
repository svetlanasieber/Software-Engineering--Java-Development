package Arrays_Lab;

import java.util.Scanner;

public class Array_example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10];
        double[] prices = new double[5];
        String[] names = new String[8];

        
        System.out.println(array.length);

     
        array[0] = 4;
        array[1] = 6;
        array[2] = 9;
        array[3] = 19;
        array[4] = 34;
        array[5] = 23;
        array[6] = 77;
        array[7] = 12;
        array[8] = 98;
        array[9] = 14;


      
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[7]);

        
        System.out.println(array[0]);

      
        System.out.println(array[array.length - 1]);

        String name = "Desi";
        //"Desi" .toCharArray() -> ['D', 'e', 's', 'i']
        char[] letters = name.toCharArray(); //['D', 'e', 's', 'i']
        System.out.println(letters[0]);
        System.out.println(letters[letters.length - 1]);



    }
}
