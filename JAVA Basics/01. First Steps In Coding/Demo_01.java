package L01_FirstStepsInCoding;

import java.util.Scanner;

public class Demo_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();
        boolean isFemale = Boolean.parseBoolean(scanner.nextLine());
        byte numbersOfBook = Byte.parseByte(scanner.nextLine());
        char symbol = scanner.nextLine().charAt(0);

    }
}
