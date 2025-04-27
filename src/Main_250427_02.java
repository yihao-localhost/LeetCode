import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/* 128. 最长连续序列 */
public class Main_250427_02 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)){
                int curMax = 0;
                int curNum = num;
                while (set.contains(curNum++)) {
                    curMax++;
                }
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
}
