package ExerciseRecursionCombinatorialProblems_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsWithoutRepetition {

    public static int[] arr;

    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        k = Integer.parseInt(bufferedReader.readLine());

        arr = new int[k];

        combine(0, 1);


    }

    private static void combine(int index, int start) {
        if (index == arr.length) {
            printArr();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combine(index + 1, i + 1);
            }
        }
    }

    private static void printArr() {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
