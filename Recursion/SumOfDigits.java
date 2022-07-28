package Recursion;

public class SumOfDigits {
    public static int evaluate(int number) {
        if (number < 0) {
            return -1;
        }
        if (number < 10) {
            return number;
        }
        return (number % 10) + evaluate(number / 10);
    }

    public static void main(String args[]) {
        System.out.print(evaluate(0));
    }
}
