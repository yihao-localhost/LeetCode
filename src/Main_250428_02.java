import java.util.ArrayList;
import java.util.List;

/* 57. �������� */
public class Main_250428_02 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // ������н���ʱ��С�������俪ʼ������
        while (i < n && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }

        // �ϲ��������������ص�������
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[]{newStart, newEnd});

        // ���ʣ������
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}