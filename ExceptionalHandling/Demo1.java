package ExceptionalHandling;

public class Demo1 {
    public static void main(String args[]) {
        System.out.println("Start");
        try {
            int a = 10;
            int b = 10;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("You are enter wrong input");
        }
        System.out.println("End");

    }
}
