package L4_ConditionalStatements_Exercise;

import java.util.Scanner;

public class P01_SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int result = a + b + c;

        int minutes = result / 60;
        int seconds = result % 60;

        if (seconds < 10) {
            System.out.printf("%d:0%d%n", minutes, seconds);
        }
        else {
            System.out.printf("%d:%d%n", minutes, seconds);
        }

    }
}
