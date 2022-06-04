import java.util.Scanner;

public class NQueen {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] state = new int[n][n];

        printNQueens(0, state, "");

    }

    public static void printNQueens(int row, int[][] state, String asf) {

        for (int col = 0; col < state.length; col++) {
            if (canBePlaced(row, col, state)) {
                String newasf = asf + row + "-" + col + ", ";
                markAllRelated(row, col, state);
                if (row == state.length - 1) {
                    System.out.println(newasf + ".");
                    displayBoard(state);
                } else {
                    printNQueens(row + 1, state, newasf);
                }
                unmarkRelated(row, col, state);
            }
        }

    }

    public static void markAllRelated(int row, int col, int[][] state) {

        for (int i = row; i < state.length; i++) {
            state[i][col]++;
        }

        for (int i = row + 1, j = col + 1; i < state.length && j < state.length; i++, j++) {
            state[i][j]++;
        }

        for (int i = row + 1, j = col - 1; i < state.length && j > -1; i++, j--) {
            state[i][j]++;
        }
    }

    public static void unmarkRelated(int row, int col, int[][] state) {

        for (int i = row; i < state.length; i++) {
            state[i][col]--;
        }

        for (int i = row + 1, j = col + 1; i < state.length && j < state.length; i++, j++) {
            state[i][j]--;
        }

        for (int i = row + 1, j = col - 1; i < state.length && j > -1; i++, j--) {
            state[i][j]--;
        }
    }

    public static boolean canBePlaced(int row, int col, int[][] state) {
        if (state[row][col] != 0) {
            return false;
        }
        return true;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}