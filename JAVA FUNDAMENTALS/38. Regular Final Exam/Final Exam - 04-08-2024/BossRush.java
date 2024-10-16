import java.util.Scanner;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String input = scanner.nextLine();
            if (isValidInput(input)) {

                String[] parts = input.split(":");
                String bossRushName = parts[0].substring(1, parts[0].length() - 1);
                String title = parts[1].substring(1, parts[1].length() - 1);

                System.out.printf("%s, The %s%n", bossRushName, title);
                System.out.printf(">> Strength: %d%n", bossRushName.length());
                System.out.printf(">> Armor: %d%n", title.length());
            } else {
                System.out.println("Access denied!");
            }
        }

        scanner.close();
    }

    private static boolean isValidInput(String input) {
        if (!input.contains(":") || input.indexOf(":") != input.lastIndexOf(":")) {
            return false;
        }

        String[] parts = input.split(":");
        if (parts.length != 2) {
            return false;
        }

        String bossRushName = parts[0];
        if (bossRushName.length() < 6 || bossRushName.charAt(0) != '|' || bossRushName.charAt(bossRushName.length() - 1) != '|') {
            return false;
        }

        bossRushName = bossRushName.substring(1, bossRushName.length() - 1);
        if (bossRushName.length() < 4 || !bossRushName.equals(bossRushName.toUpperCase())) {
            return false;
        }
        String title = parts[1];
        if (title.length() < 4 || title.charAt(0) != '#' || title.charAt(title.length() - 1) != '#') {
            return false;
        }

        title = title.substring(1, title.length() - 1);
        String[] titleParts = title.split(" ");
        if (titleParts.length != 2 || !titleParts[0].matches("[a-zA-Z]+") || !titleParts[1].matches("[a-zA-Z]+")) {
            return false;
        }

        return true;
    }
}
