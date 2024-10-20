import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumFirstDigit = Integer.parseInt(scanner.nextLine());
        int firstNumSecondDigit = Integer.parseInt(scanner.nextLine());
        int secondNumFirstDigit = Integer.parseInt(scanner.nextLine());
        int secondNumSecondDigit = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean hasEnded = false;

        for (int firstNumFirstD = firstNumFirstDigit; firstNumFirstD <= 8; firstNumFirstD++) {
            for (int firstNumSecondDig = 9; firstNumSecondDig >= firstNumSecondDigit; firstNumSecondDig--) {
                for (int secondNumFirstDig = secondNumFirstDigit; secondNumFirstDig <= 8; secondNumFirstDig++) {
                    for (int secondNumSecondDig = 9; secondNumSecondDig >= secondNumSecondDigit; secondNumSecondDig--) {
                        boolean isValid = firstNumFirstD % 2 == 0 &&
                                          secondNumFirstDig % 2 == 0 &&
                                          firstNumSecondDig % 2 != 0 &&
                                          secondNumSecondDig % 2 != 0;

                        int firstNum = firstNumFirstD * 10 + firstNumSecondDig;
                        int secondNum = secondNumFirstDig * 10 + secondNumSecondDig;

                        if (isValid && firstNum == secondNum) {
                            System.out.println("Cannot change the same player.");
                        } else if (isValid && firstNum != secondNum) {
                            System.out.printf("%d%d - %d%d%n", firstNumFirstD, firstNumSecondDig, secondNumFirstDig, secondNumSecondDig);
                            counter++;
                        }
                        if (counter >= 6) {
                            hasEnded = true;
                        }
                        if (hasEnded) {
                            break;
                        }
                    }
                    if (hasEnded) {
                        break;
                    }
                }
                if (hasEnded) {
                    break;
                }
            }
            if (hasEnded) {
                break;
            }
        }

        scanner.close();
    }
}
