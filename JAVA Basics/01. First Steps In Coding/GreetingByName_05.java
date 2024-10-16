import java.util.Scanner;

public class GreetingByName_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //"Hello, <name>!"
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");

    }
}
