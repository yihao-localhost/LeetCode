import java.util.HashMap;
import java.util.Map;

/* 76. ��С�����Ӵ� */
public class Main_250420_02 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // ��¼ t ���ַ�����
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        // �������ڵ��ַ�����
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0; // ��������ָ��
        int valid = 0; // �����������ַ�������
        int start = 0; // ��С���ڵ���ʼλ��
        int minLen = Integer.MAX_VALUE; // ��С���ڳ���

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // ���´�������
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // ��ǰ�ַ�������������ʱ��valid++
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            // �����ڸ��������ַ�ʱ��������С��߽�
            while (valid == needs.size()) {
                // ������С����
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left);
                left++;
                // ���´�������
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
