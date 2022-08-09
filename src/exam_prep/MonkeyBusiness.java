package exam_prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkeyBusiness {

    public static int n;
    public static int solutions = 0;
    public static int[] expression;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        expression = new int[n];
        combinationsWithoutRepeat(0, 1);

        stringBuilder.append("Total Solutions: ").append(solutions);
        System.out.println(stringBuilder.toString());
    }

    private static void combinationsWithoutRepeat(int index, int start) {
        if (index >= n) {
            printSolution();
        } else {
            for (int i = start; i <= n; i++) {
                expression[index] = i;
                combinationsWithoutRepeat(index + 1, i + 1);
                expression[index] = -i;
                combinationsWithoutRepeat(index + 1, i + 1);
            }
        }
    }

    private static void printSolution() {
        int sum = Arrays.stream(expression).sum();

        if (sum == 0) {
            solutions++;
            for (int ex : expression) {
                String numberAsStr = ex > 0 ? "+" + ex : String.valueOf(ex);
               stringBuilder.append(numberAsStr).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
        }
    }
}
