package L3_ConditionalStatements_Lab;

import java.util.Scanner;

public class tomato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String color = scanner.nextLine();
        //String color = "red";

        if (color.equals("red"))
            System.out.println("tomato");
        else
            System.out.println("banana");
        System.out.println("bye");

    }
}
