package L09_Iterators_and_Comparators;

public class MainLab {
    public static void main(String[] args) {

        //A: Arrays
        String[] names = new String[5];
        names[0] = "Vik";
        names[1] = "Desi";
        names[2] = "Gosho";
        names[3] = "Ivan";
        names[4] = "Raja";
        //print(names);

        //B: Varargs = позволява ни да подаваме стойности (от 0 до n)
        //print();
        // Правила:
        // 1. Имаме право само на 1 varargs аргумент
        // 2. Тип varargs се ползва само за аргументи на методи
        // НЕ МОЖЕ String... books = "Harry Potter", "Hobbit";
        // 3. Тип varargs аргумент се слага последен в сигнатурата на метода

        print("Bulgaria", "Ivan", "Gosho", "Ivan", "Raja");
        print("Bulgaria", "Desi");
        print("Bulgaria");
    }


    private static void print(String country, String... names) {
        // този varargs параметър ще работи като масив

        //System.out.println(names[0]);


        for (String name : firstNames) {
            System.out.println(name);
        }
    }

}
