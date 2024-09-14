package L3_ConditionalStatements_Lab;

import java.util.Scanner;

public class boolean_example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        boolean isPositive = number > 0;

        System.out.println(isPositive);
    }
}
