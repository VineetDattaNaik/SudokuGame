import java.util.Random;

public class SudokuGenerator {
    private static final int SIZE = 9;
    private int[][] board = new int[SIZE][SIZE];
    private int[][] solvedBoard = new int[SIZE][SIZE]; // Stores the complete solution

    public SudokuGenerator() {
        fillBoard();
        copySolution(); // Save the full solution before removing numbers
        removeNumbers(40); // Remove numbers to create the puzzle
    }

    private void fillBoard() {
        fillDiagonal();
        fillRemaining(0, 3);
    }

    private void fillDiagonal() {
        for (int i = 0; i < SIZE; i += 3) {
            fillBox(i, i);
        }
    }

    private void fillBox(int row, int col) {
        Random rand = new Random();
        boolean[] used = new boolean[SIZE + 1];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = rand.nextInt(SIZE) + 1;
                } while (used[num]);
                used[num] = true;
                board[row + i][col + j] = num;
            }
        }
    }

    private boolean fillRemaining(int row, int col) {
        if (row == SIZE - 1 && col == SIZE)
            return true;
        if (col == SIZE) {
            row++;
            col = 0;
        }
        if (board[row][col] != 0)
            return fillRemaining(row, col + 1);

        for (int num = 1; num <= SIZE; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (fillRemaining(row, col + 1))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int num) {
        return !usedInRow(row, num) && !usedInCol(col, num) && !usedInBox(row - row % 3, col - col % 3, num);
    }

    private boolean usedInRow(int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == num)
                return true;
        }
        return false;
    }

    private boolean usedInCol(int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == num)
                return true;
        }
        return false;
    }

    private boolean usedInBox(int rowStart, int colStart, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowStart + i][colStart + j] == num)
                    return true;
            }
        }
        return false;
    }

    private void removeNumbers(int count) {
        Random rand = new Random();
        while (count > 0) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                count--;
            }
        }
    }

    private void copySolution() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                solvedBoard[i][j] = board[i][j];
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getSolution() {
        return solvedBoard;
    }
}
