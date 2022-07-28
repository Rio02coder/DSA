package Recursion;

public class GCD {
    public static int evaluate(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        return evaluate(b, a % b);
    }

    public static void main(String args[]) {
        System.out.println(evaluate(48, 18));
    }
}
