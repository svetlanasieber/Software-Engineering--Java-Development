package Methods_Lab;

public class MainLab {
    public static void main(String[] args) {

        //A:
        String[] names = new String[5];
        names[0] = "Vik";
        names[1] = "Desi";
        names[2] = "Gosho";
        names[3] = "Ivan";
        names[4] = "Raja";
        //print(names);

        //1. Varargs =
        //print();
        print("Vik", "Ivan", "Gosho", "Ivan", "Raja");
    }
//B: VarArgs (String... names)
    private static void print(String... names) {

        for (String name : names) {
            System.out.println(name);
        }
    }

}
