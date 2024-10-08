package Methods_Lab;

public class MainLab {
    public static void main(String[] args) {

        //A: Arrays
        String[] names = new String[5];
        names[0] = "Vik";
        names[1] = "Desi";
        names[2] = "Gosho";
        names[3] = "Ivan";
        names[4] = "Raja";
        print(names);

        //B: Varargs
        //print();
        print("Vik", "Ivan", "Gosho", "Ivan", "Raja");
    }


    private static void print(String... names) {
        // this varargs works like a Array

        System.out.println(names[0]);


        for (String name : names) {
            System.out.println(name);
        }
    }

}
