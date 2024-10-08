package Arrays_Lab;

public class Array_String {
    public static void main(String[] args) {
        String[] names = new String[10];
        names[0] = "Desi";
        names[1] = "Ivan";
        names[2] = "Miroslav";
        //valid positions: >= 0 and < length
        System.out.println(names[8]);
    }
}
