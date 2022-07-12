package recursion_and_backtracking_02;

import java.util.Scanner;

public class QueensPuzzle {

    public static char[][] board = {
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',}
    };

    public static boolean[][] freePositions = new boolean[8][8];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                freePositions[r][c] = true;
            }
        }

        findQueenPositions(0);

    }

    private static void findQueenPositions(int row) {
        if (row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < 7; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPositions(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
        markFreePositions(row, col, true);
    }

    private static void putQueen(int row, int col) {
        board[row][col] = '*';
        markFreePositions(row, col, false);
    }

    private static void markFreePositions(int row, int col, boolean value) {
        for (int c = 0; c < 8; c++) {
            freePositions[row][c] = value;
        }

        for (int r = 0; r < 8; r++) {
            freePositions[r][col] = value;
        }

        int r = row, c = col;

        while (r >= 0 && c >= 0) {
            freePositions[r--][c--] = value;
        }

        r = row;
        c = col;

        while (r < 8 && c < 8) {
            freePositions[r++][c++] = value;
        }

        r = row;
        c = col;

        while (r >= 0 && c < 8) {
            freePositions[r--][c++] = value;
        }

        r = row;
        c = col;

        while (r < 8 && c >= 0 ) {
            freePositions[r++][c--] = value;
        }
    }

    private static boolean canPlaceQueen(int row, int col) {
        return !freePositions[row][col];
    }

    public static void printSolution() {
        for (char[] chars : board) {
            for (char symbol : chars) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
