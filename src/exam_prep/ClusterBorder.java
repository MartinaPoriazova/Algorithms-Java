package exam_prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClusterBorder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] singleShipTimes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] pairShipTimes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[singleShipTimes.length + 1];

        dp[1] = singleShipTimes[0];

        for (int i = 2; i <= singleShipTimes.length; i++) {
            int singleShipTime = dp[i - 1] + singleShipTimes[i - 1];
            int pairShipTime = dp[i - 2] + pairShipTimes[i - 2];
            dp[i] = Math.min(singleShipTime, pairShipTime);
        }

        System.out.println("Optimal Time: " + dp[singleShipTimes.length]);

        List<String> out = new ArrayList<>();

        for (int i = dp.length - 1; i > 0; i--) {
            int timeDiffForLatestTwo = dp[i] - dp[i - 1];
            if (timeDiffForLatestTwo == singleShipTimes[i - 1]) {
                out.add("Single " + i);
            } else {
                out.add("Pair of " + (i - 1) + " and " + i);
                i--;
            }
        }

        for (int i = out.size() - 1; i >= 0; i--) {
            System.out.println(out.get(i));
        }
    }
}
