import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

       
        double tShirtPrice = Double.parseDouble(scanner.nextLine());
        double targetAmount = Double.parseDouble(scanner.nextLine());

      
        double shortsPrice = tShirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.20;
        double shoesPrice = (tShirtPrice + shortsPrice) * 2;

   
        double totalPrice = tShirtPrice + shortsPrice + socksPrice + shoesPrice;

   
        totalPrice -= totalPrice * 0.15;

       
        if (totalPrice >= targetAmount) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.%n", totalPrice);
        } else {
            double neededMoney = targetAmount - totalPrice;
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.%n", neededMoney);
        }

       
        scanner.close();
    }
}
