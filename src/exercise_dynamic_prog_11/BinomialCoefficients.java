package exercise_dynamic_prog_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoefficients {
    public static long[][] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        memory = new long[n + 1][k + 1];

        long binom = calculateBinom(n, k);

        System.out.println(binom);
    }

    private static long calculateBinom(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        if (memory[n][k] != 0) {
            return memory[n][k];
        }

        return memory[n][k] = calculateBinom(n - 1, k) + calculateBinom(n - 1, k - 1);
    }
}
