import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 228. »ã×ÜÇø¼ä */
public class Main_250427_03 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nums[i]);
            if (i != nums.length - 1 && nums[i + 1] - 1 == nums[i]) {
                while (nums[i + 1] - 1 == nums[i]) {
                    i++;
                }
                stringBuilder.append("->").append(nums[i]);
            }
            list.add(stringBuilder.toString());
        }
        return list;
    }
}
