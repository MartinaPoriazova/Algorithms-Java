package exercise_dynamic_prog_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LongestZigzagSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[numbers.length + 1][2];
        int[][] prev = new int[numbers.length + 1][2];

        // Greater
        dp[0][0] = 1;
        // Lesser
        dp[0][1] = 1;

        prev[0][0] = -1;
        prev[0][1] = -1;

        int maxLength = 0;

        int[] best = new int[2];

        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            int currentNumber = numbers[currentIndex];
            for (int prefIndex = currentIndex - 1; prefIndex >= 0; prefIndex--) {
                int prevNumber = numbers[prefIndex];
                if (currentNumber > prevNumber && dp[currentIndex][0] <= dp[prefIndex][1] + 1) {
                    dp[currentIndex][0] = dp[prefIndex][1] + 1;
                    prev[currentIndex][0] = prefIndex;
                } else if (currentNumber < prevNumber && dp[currentIndex][1] <= dp[prefIndex][0] + 1) {
                    dp[currentIndex][1] = dp[prefIndex][0] + 1;
                    prev[currentIndex][1] = prefIndex;
                }
            }

            if (maxLength < dp[currentIndex][0]) {
                maxLength = dp[currentIndex][0];
                best[0] = currentIndex;
                best[1] = 0;
            } else if (maxLength < dp[currentIndex][1]) {
                maxLength = dp[currentIndex][1];
                best[0] = currentIndex;
                best[1] = 1;
            }
        }

        Deque<Integer> zigZagSequence = new ArrayDeque<>();

        int beginRow = best[0];

        while (beginRow >= 0) {
            zigZagSequence.push(numbers[beginRow]);
            beginRow = prev[beginRow][best[1]];
            best[1] = best[1] == 0 ? 1 : 0;
        }

        while (!zigZagSequence.isEmpty()) {
            System.out.print(zigZagSequence.pop() + " ");
        }
    }
}
