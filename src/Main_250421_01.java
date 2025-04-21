/* 36. 有效的数独 */
public class Main_250421_01 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = (int)c - 49;
                    rows[i][num]++;
                    columns[j][num]++;
                    subboxes[i/3][j/3][num]++;
                    if (rows[i][num] > 1 || columns[j][num] > 1 || subboxes[i/3][j/3][num] > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
