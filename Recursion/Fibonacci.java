package Recursion;

class Fibonacci {
    public static int evaluate(int n) {
        if (n <= 2) {
            return 1;
        }
        return evaluate(n - 1) + evaluate(n - 2);
    }

    public static void main(String args[]) {
        System.out.println(evaluate(30));
    }
}