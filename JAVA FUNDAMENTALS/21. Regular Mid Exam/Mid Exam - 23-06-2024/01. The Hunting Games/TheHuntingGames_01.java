import java.util.Scanner;

public class TheHuntingGames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int questDays = Integer.parseInt(scanner.nextLine());
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerPersonPerDay = Double.parseDouble(scanner.nextLine());
        double foodPerPersonPerDay = Double.parseDouble(scanner.nextLine());

        double totalWaterNeeded = questDays * numberOfPlayers * waterPerPersonPerDay;
        double totalFoodNeeded = questDays * numberOfPlayers * foodPerPersonPerDay;

        boolean outOfEnergy = false;

        for (int day = 1; day <= questDays; day++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            groupEnergy -= energyLoss;

            if (groupEnergy <= 0) {
                outOfEnergy = true;
                break;
            }

            if (day % 2 == 0) {
                groupEnergy *= 1.05;
                totalWaterNeeded *= 0.70;
            }


            if (day % 3 == 0) {
                groupEnergy *= 1.10;
                totalFoodNeeded -= (totalFoodNeeded / numberOfPlayers);
            }
        }


        if (outOfEnergy) {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.%n", totalFoodNeeded, totalWaterNeeded);
        } else {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!%n", groupEnergy);
        }

        scanner.close();
    }
}
