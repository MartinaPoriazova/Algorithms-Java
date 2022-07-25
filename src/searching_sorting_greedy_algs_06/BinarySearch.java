package searching_sorting_greedy_algs_06;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int element = Integer.parseInt(scanner.nextLine());

        System.out.println(indexOf(arr, element));
    }

    private static int indexOf(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int current = arr[mid];

            if (element < current) {
                end = mid - 1;
            } else if (element > current) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}