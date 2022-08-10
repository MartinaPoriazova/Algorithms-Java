package exercise_dynamic_prog_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoefficientsIter {
    public static long[][] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        memory = new long[n + 1][k + 1];

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= Math.min(row, k); col++) {
                if (col == 0 || col == row) {
                    memory[row][col] = 1;
                } else {
                    memory[row][col] =  memory[row - 1][col] + memory[row - 1][col - 1];
                }
            }
        }

        System.out.println(memory[n][k]);
    }
}
