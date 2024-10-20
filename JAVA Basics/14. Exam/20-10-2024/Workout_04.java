import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        int n = Integer.parseInt(scanner.nextLine()); 
        double m = Double.parseDouble(scanner.nextLine()); 

        double totalKilometers = m;

      
        for (int i = 0; i < n; i++) {
            int percentIncreaseMem = Integer.parseInt(scanner.nextLine());
            m += m * percentIncreaseMem / 100.0;
            totalKilometers += m;
        }

       
        if (totalKilometers >= 1000) {
            System.out.printf("You've done a great job running %.0f more kilometers!%n", Math.ceil(totalKilometers - 1000));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers%n", Math.ceil(1000 - totalKilometers));
        }

        scanner.close();
    }
}
