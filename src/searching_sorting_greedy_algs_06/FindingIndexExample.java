package searching_sorting_greedy_algs_06;

import java.util.Scanner;

public class FindingIndexExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = {13, 2, 34, 73, 24, 86};
        System.out.println(indexOf(arr, n));
    }

    private static int indexOf(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
}