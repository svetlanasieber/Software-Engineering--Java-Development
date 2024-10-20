import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

     
        int numOfDancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String location = scanner.nextLine();

        double moneyPrize = 0;

       
        if (location.equals("Bulgaria")) {
            moneyPrize = points * numOfDancers;
            if (season.equals("summer")) {
                moneyPrize -= 0.05 * moneyPrize;
            } else if (season.equals("winter")) {
                moneyPrize -= 0.08 * moneyPrize;
            }
        } else if (location.equals("Abroad")) {
            moneyPrize = points * numOfDancers + 0.5 * (points * numOfDancers);
            if (season.equals("summer")) {
                moneyPrize -= 0.10 * moneyPrize;
            } else if (season.equals("winter")) {
                moneyPrize -= 0.15 * moneyPrize;
            }
        }

       
        double charityMoney = 0.75 * moneyPrize;
        double moneyAfterCharity = moneyPrize - charityMoney;
        double moneyPerDancer = moneyAfterCharity / numOfDancers;

       
        System.out.printf("Charity - %.2f%n", charityMoney);
        System.out.printf("Money per dancer - %.2f%n", moneyPerDancer);
    }
}
