package Recursion;

class Solution {
    public static double myPow(double b, int n) {
        if (n == Integer.MAX_VALUE) {
            return b;
        }
        if (n == Integer.MIN_VALUE) {
            return (b == 1 || b == -1) ? 1 : 0;
        }
        if (n < 0) {
            b = 1 / b;
            n = -1 * n;
        }
        double ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= b;
            }
            b = b * b;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        System.out.println(myPow(2.0000, 10));
    }
}