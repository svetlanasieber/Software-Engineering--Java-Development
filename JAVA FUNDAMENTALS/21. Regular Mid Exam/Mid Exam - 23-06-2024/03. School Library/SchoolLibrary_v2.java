import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SchoolLibrary_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> books = new ArrayList<>(Arrays.asList(scanner.nextLine().split("&")));

        while (true) {
            String commands = scanner.nextLine();
            if (commands.equals("Done")) {
                break;
            }

            String[] commandParts = commands.split(" \\| ");
            String command = commandParts[0];

            if (command.equals("Swap Books")) {
                String firstBook = commandParts[1];
                String secondBook = commandParts[2];

                if (books.contains(firstBook) && books.contains(secondBook)) {
                    int firstBookIndex = books.indexOf(firstBook);
                    int secondBookIndex = books.indexOf(secondBook);

                    books.set(firstBookIndex, secondBook);
                    books.set(secondBookIndex, firstBook);
                }
            } else {
                String bookName = commandParts[1];
                switch (command) {
                    case "Add Book":
                        if (!books.contains(bookName)) {
                            books.add(0, bookName);
                        }
                        break;
                    case "Take Book":
                        books.remove(bookName);
                        break;
                    case "Insert Book":
                        if (!books.contains(bookName)) {
                            books.add(bookName);
                        }
                        break;
                    case "Check Book":
                        int index = Integer.parseInt(bookName);
                        if (index >= 0 && index < books.size()) {
                            System.out.println(books.get(index));
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println(String.join(", ", books));

        scanner.close();
    }
}
