import java.util.Arrays;
import java.util.Comparator;

/* 452. 用最少数量的箭引爆气球 */
public class Main_250429_01 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int ans = points.length;
        for (int i = 0; i < points.length;) {
            int j = i + 1;
            while (j < points.length && points[i][1] <= points[j][1] && points[i][1] >= points[j][0]) {
                j++;
                ans--;
            }
            i = j;
        }
        return ans;
    }
}
