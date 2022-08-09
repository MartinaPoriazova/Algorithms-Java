package exam_prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkeyBusiness2 {

    public static int n;
    public static int solutions = 0;
    public static int[] expression;
    public static int[] numbers;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        expression = new int[n];
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        combinationsWithoutRepeat(0);

        stringBuilder.append("Total Solutions: ").append(solutions);
        System.out.println(stringBuilder.toString());
    }

    private static void combinationsWithoutRepeat(int index) {
        if (index >= n) {
            printSolution();
        } else {
                expression[index] = numbers[index];
                combinationsWithoutRepeat(index + 1);
                expression[index] = -numbers[index];
                combinationsWithoutRepeat(index + 1);
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
