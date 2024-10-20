import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysCounter = 1;
        int metersCounter = 5364;
        boolean isSucceeded = false;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("END")) {
                break;
            }

            String isSpendingTheNight = command.toLowerCase();
            if (isSpendingTheNight.equals("yes")) {
                daysCounter++;
            }

            int climbedMeters = Integer.parseInt(scanner.nextLine());
            if (daysCounter > 5) {
                isSucceeded = false;
                break;
            }

            metersCounter += climbedMeters;

            if (metersCounter >= 8848) {
                isSucceeded = true;
                break;
            }
        }

        if (isSucceeded) {
            System.out.printf("Goal reached for %d days!%n", daysCounter);
        } else {
            System.out.println("Failed!");
            System.out.println(metersCounter);
        }

        scanner.close();
    }
}
