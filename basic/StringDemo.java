package basic;

public class StringDemo {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        String c= new String("a");
        String d = new String("a").intern();

        System.out.println("a == b ?"+ (a == b));
        System.out.println("a == c ?"+ (a == c));
        System.out.println("a == d ?"+ (a == d));
    }
}
