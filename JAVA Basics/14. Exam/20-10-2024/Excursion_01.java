import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

 
        int people = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        int transportCards = Integer.parseInt(scanner.nextLine());
        int museumTickets = Integer.parseInt(scanner.nextLine());

   
        double nightPrice = 20.00;
        double transportCardPrice = 1.60;
        double museumTicketPrice = 6.00;

   
        double totalPerPerson = (nights * nightPrice) +
                                (transportCards * transportCardPrice) +
                                (museumTickets * museumTicketPrice);

       
        double totalGroup = totalPerPerson * people;

        totalGroup += totalGroup * 0.25;

        System.out.printf("%.2f%n", totalGroup);

       
        scanner.close();
    }
}
