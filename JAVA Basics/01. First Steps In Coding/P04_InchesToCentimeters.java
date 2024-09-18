package L01_FirstStepsInCoding;

import java.util.Scanner;

public class P04_InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inches = Double.parseDouble(scanner.nextLine());

        //2.54 (1 inch = 2.54 centimeters)
        double centimeters = inches * 2.54;
        //System.out.printf("%.2f", centimeters);
        System.out.println(centimeters);

    }
}
