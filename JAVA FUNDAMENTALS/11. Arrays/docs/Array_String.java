package Arrays_Lab;

public class Array_String {
    public static void main(String[] args) {
        String[] names = new String[10]; //[null, null, null, null, null, null, null, null, null, null]
        names[0] = "Desi";//["Desi", null, null, null, null, null, null, null, null, null]
        names[1] = "Ivan";//["Desi", "Ivan", null, null, null, null, null, null, null, null]
        names[2] = "Miroslav";//["Desi", "Ivan", "Miroslav", null, null, null, null, null, null, null]
        //valid positions: >= 0 and < length
        System.out.println(names[8]);
    }
}
