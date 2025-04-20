import java.util.HashMap;
import java.util.Map;

/* 76. 最小覆盖子串 */
public class Main_250420_02 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 记录 t 的字符需求
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口的字符计数
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0; // 窗口左右指针
        int valid = 0; // 满足条件的字符种类数
        int start = 0; // 最小窗口的起始位置
        int minLen = Integer.MAX_VALUE; // 最小窗口长度

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 更新窗口数据
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 当前字符数量满足需求时，valid++
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            // 当窗口覆盖所有字符时，尝试缩小左边界
            while (valid == needs.size()) {
                // 更新最小窗口
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left);
                left++;
                // 更新窗口数据
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
