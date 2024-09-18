package L01_FirstStepsInCoding;

import java.util.Scanner;

public class P05_GreetingByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //"Hello, <name>!"
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");

    }
}
