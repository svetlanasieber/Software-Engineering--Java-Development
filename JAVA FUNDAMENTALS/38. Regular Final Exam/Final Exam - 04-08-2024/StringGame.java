import java.util.Scanner;

public class StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String startString = scanner.nextLine();

        while (true) {

            String line = scanner.nextLine();

            if (line.equals("Done")) {
                break;
            }


            String[] commandArgs = line.split(" ");
            String command = commandArgs[0];

            switch (command) {
                case "Change":
                    String oldChar = commandArgs[1];
                    String newChar = commandArgs[2];
                    startString = startString.replace(oldChar, newChar);
                    System.out.println(startString);
                    break;

                case "Includes":
                    String substring = commandArgs[1];
                    if (startString.contains(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "End":
                    substring = commandArgs[1];
                    if (startString.endsWith(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Uppercase":
                    startString = startString.toUpperCase();
                    System.out.println(startString);
                    break;

                case "FindIndex":
                    String charToFind = commandArgs[1];
                    int charPosition = startString.indexOf(charToFind);
                    System.out.println(charPosition);
                    break;

                case "Cut":
                    int startIdx = Integer.parseInt(commandArgs[1]);
                    int positionCount = Integer.parseInt(commandArgs[2]);
                    String cutString = startString.substring(startIdx, startIdx + positionCount);
                    System.out.println(cutString);
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }
        }

        scanner.close();
    }
}

