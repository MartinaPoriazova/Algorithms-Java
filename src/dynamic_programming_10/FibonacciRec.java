package dynamic_programming_10;

import java.util.Scanner;

public class FibonacciRec {
    public static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        dp = new long[n + 1];

        long fibonacci = calcFib(n);

        System.out.println(fibonacci);
    }

    private static long calcFib(int n) {
        if (n <= 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = calcFib(n - 1) + calcFib(n - 2);
    }
}
