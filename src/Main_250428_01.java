import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* 56. 合并区间 */
public class Main_250428_01 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        List<int[]> list = new ArrayList<>();
        int i = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        while (i < intervals.length){
            int j = i + 1;
            int L = intervals[i][0];
            int R = intervals[i][1];
            while (j < intervals.length) {
                if (R <= intervals[j][1] && R >= intervals[j][0] || R >= intervals[j][1] && L <= intervals[j][0]) {
                    L = Math.min(L, intervals[j][0]);
                    R = Math.max(R, intervals[j][1]);
                    j++;
                }
                else
                    break;
            }
            list.add(new int[]{L, R});
            i = j;
        }
        return list.toArray(new int[list.size()][]);
    }
}
