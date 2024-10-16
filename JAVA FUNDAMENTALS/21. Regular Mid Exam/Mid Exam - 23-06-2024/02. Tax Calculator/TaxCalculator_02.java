import java.util.Scanner;

public class TaxCalculator_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carList = scanner.nextLine().split(">>");
        double totalTax = 0;

        for (String car : carList) {
            String[] command = car.split(" ");
            String typeCar = command[0];
            int years = Integer.parseInt(command[1]);
            int distance = Integer.parseInt(command[2]);

            double tax = 0;
            boolean validCarType = true;

            switch (typeCar) {
                case "family":
                    tax = familyCar(distance, years);
                    break;
                case "heavyDuty":
                    tax = heavyDutyCar(distance, years);
                    break;
                case "sports":
                    tax = sportsCar(distance, years);
                    break;
                default:
                    System.out.println("Invalid car type.");
                    validCarType = false;
                    break;
            }

            if (validCarType) {
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", typeCar, tax);
                totalTax += tax;
            }
        }

        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n", totalTax);

        scanner.close();
    }

    public static double familyCar(int currentDistance, int currentYears) {
        double currentTax = 50;
        currentTax -= 5 * currentYears;
        int multiplier = currentDistance / 3000;
        if (currentDistance >= 3000) {
            currentTax += 12 * multiplier;
        }
        return currentTax;
    }

    public static double heavyDutyCar(int currentDistance, int currentYears) {
        double currentTax = 80;
        currentTax -= 8 * currentYears;
        int multiplier = currentDistance / 9000;
        if (currentDistance >= 9000) {
            currentTax += 14 * multiplier;
        }
        return currentTax;
    }

    public static double sportsCar(int currentDistance, int currentYears) {
        double currentTax = 100;
        currentTax -= 9 * currentYears;
        int multiplier = currentDistance / 2000;
        if (currentDistance >= 2000) {
            currentTax += 18 * multiplier;
        }
        return currentTax;
    }
}
