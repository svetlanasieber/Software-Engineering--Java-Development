import java.util.Scanner;

public class Beesy_02 {
    private static int energy = 15;
    private static int nectarCollected = 0;
    private static boolean energyRestored = false;
    private static int startRow, startCol;
    private static char[][] field;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        field = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < n; col++) {
                field[row][col] = line.charAt(col);
                if (field[row][col] == 'B') {
                    startRow = row;
                    startCol = col;
                }
            }
        }


        while (energy > 0 && scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }
            moveBee(command);
        }

        printResult();
        printField();
    }

    private static void moveBee(String direction) {
        int newRow = startRow, newCol = startCol;

        switch (direction) {
            case "up":    newRow = (startRow - 1 + field.length) % field.length; break;
            case "down":  newRow = (startRow + 1) % field.length; break;
            case "left":  newCol = (startCol - 1 + field.length) % field.length; break;
            case "right": newCol = (startCol + 1) % field.length; break;
        }

        energy--;

        if (field[newRow][newCol] == 'H') {
            field[startRow][startCol] = '-';
            startRow = newRow;
            startCol = newCol;
            if (nectarCollected >= 30) {
                System.out.println("Great job, Beesy! The hive is full. Energy left: " + energy);
                field[startRow][startCol] = 'B';
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
                field[startRow][startCol] = 'B';
            }
            printField();
            System.exit(0);
        } else if (Character.isDigit(field[newRow][newCol])) {
            nectarCollected += Character.getNumericValue(field[newRow][newCol]);
            field[newRow][newCol] = '-';
        }

        field[startRow][startCol] = '-';
        startRow = newRow;
        startCol = newCol;
        field[startRow][startCol] = 'B';

        if (energy <= 0) {
            if (nectarCollected >= 30 && !energyRestored) {
                int extraNectar = nectarCollected - 30;
                energy += extraNectar;
                nectarCollected = 30;
                energyRestored = true;
            }

            if (energy <= 0) {
                if (nectarCollected < 30) {
                    System.out.println("Beesy did not manage to collect enough nectar.");
                } else {
                    System.out.println("This is the end! Beesy ran out of energy.");
                }
                printField();
                System.exit(0);
            }
        }
    }

    private static void printResult() {
        
    }

    private static void printField() {
        for (char[] row : field) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
