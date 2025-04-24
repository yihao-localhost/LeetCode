import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 289. ÉúÃüÓÎÏ· */
public class Main_250424_02 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m + 2][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                life(i, j, newBoard, board);
            }
        }
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void life(int i, int j, int[][] newBoard, int[][] board) {
        int liveNeighbors = 0;
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                if (k == i && l == j)
                    continue;
                if (newBoard[k][l] == 1)
                    liveNeighbors++;
            }
        }
        if (newBoard[i][j] == 1 && liveNeighbors < 2)
            board[i - 1][j - 1] = 0;
        else if (newBoard[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3))
            board[i - 1][j - 1] = 1;
        else if (newBoard[i][j] == 1 && liveNeighbors > 3)
            board[i - 1][j - 1] = 0;
        else if (newBoard[i][j] == 0 && liveNeighbors == 3)
            board[i - 1][j - 1] = 1;
    }

    public static void main(String[] args) {
        new Main_250424_02().gameOfLife(new int[][] {
                                            {0, 1, 0},
                                            {0, 0, 1},
                                            {1, 1, 1},
                                            {0, 0, 0}
                                        });
    }
}
