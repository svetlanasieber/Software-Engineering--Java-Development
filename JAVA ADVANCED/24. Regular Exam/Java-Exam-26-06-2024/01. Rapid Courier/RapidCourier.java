import java.util.*;

public class RapidCourier_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] packageWeightsStr = scanner.nextLine().split(" ");
        LinkedList<Integer> packages = new LinkedList<>();
        for (String s : packageWeightsStr) {
            packages.add(Integer.parseInt(s));
        }

        String[] courierCapacitiesStr = scanner.nextLine().split(" ");
        Queue<Integer> couriers = new LinkedList<>();
        for (String s : courierCapacitiesStr) {
            couriers.add(Integer.parseInt(s));
        }

        int totalWeight = 0;

        while (!packages.isEmpty() && !couriers.isEmpty()) {
            int currentPackage = packages.pollLast();
            int currentCourier = couriers.poll();

            if (currentCourier >= currentPackage) {
                totalWeight += currentPackage;
                currentCourier -= 2 * currentPackage;
                if (currentCourier > 0) {
                    couriers.add(currentCourier);
                }
            } else {
                totalWeight += currentCourier;
                currentPackage -= currentCourier;
                packages.addLast(currentPackage);
            }
        }

    
        System.out.println("Total weight: " + totalWeight + " kg");

        if (packages.isEmpty() && couriers.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (!packages.isEmpty() && couriers.isEmpty()) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            for (int i = 0; i < packages.size(); i++) {
                if (i == packages.size() - 1) {
                    System.out.print(packages.get(i));
                } else {
                    System.out.print(packages.get(i) + ", ");
                }
            }
            System.out.println();
        } else if (packages.isEmpty() && !couriers.isEmpty()) {
            System.out.print("Couriers are still on duty: ");
            for (int i = 0; i < couriers.size(); i++) {
                if (i == couriers.size() - 1) {
                    System.out.print(((LinkedList<Integer>) couriers).get(i));
                } else {
                    System.out.print(((LinkedList<Integer>) couriers).get(i) + ", ");
                }
            }
            System.out.println(" but there are no more packages to deliver.");
        }
    }
}
