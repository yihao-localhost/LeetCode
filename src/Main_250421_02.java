import java.util.ArrayList;
import java.util.List;

/* 54. ÂİĞı¾ØÕó */
public class Main_250421_02 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;
        while(u <= d && l <= r){
            for(int j = l; u <= d && j <= r; j++) {
                res.add(matrix[u][j]);
            }
            u++;
            for(int i = u; l <= r && i <= d; i++){
                res.add(matrix[i][r]);
            }
            r--;
            for(int j = r; u <= d && j >= l; j--) {
                res.add(matrix[d][j]);
            }
            d--;
            for(int i = d; l <= r && i >= u; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}
