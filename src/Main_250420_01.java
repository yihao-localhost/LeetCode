import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 30. 串联所有单词的子串 */
public class Main_250420_01 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.isEmpty()) {
            return ans;
        }

        int n = words.length;
        int m = words[0].length();
        int totalLen = n * m;
        int sLen = s.length();

        if (sLen < totalLen) {
            return ans;
        }

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        for (int r = 0; r < m; r++) {
            int left = r;
            int right = left + totalLen;
            if (right > sLen) {
                continue;
            }

            Map<String, Integer> currCount = new HashMap<>();
            for (int k = 0; k < n; k++) {
                int start = left + k * m;
                String word = s.substring(start, start + m);
                currCount.put(word, currCount.getOrDefault(word, 0) + 1);
            }

            if (currCount.equals(count)) {
                ans.add(left);
            }

            while (left + m + totalLen <= sLen) {
                String removedWord = s.substring(left, left + m);
                currCount.put(removedWord, currCount.get(removedWord) - 1);
                if (currCount.get(removedWord) == 0) {
                    currCount.remove(removedWord);
                }
                left += m;

                int newWordStart = left + (n - 1) * m;
                String newWord = s.substring(newWordStart, newWordStart + m);
                currCount.put(newWord, currCount.getOrDefault(newWord, 0) + 1);

                if (currCount.equals(count)) {
                    ans.add(left);
                }
            }
        }

        return ans;
    }
}