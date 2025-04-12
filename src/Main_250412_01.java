/* 28. 找出字符串中第一个匹配项的下标 */
public class Main_250412_01 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int m = haystack.length();
        int n = needle.length();
        if (n > m) return -1;
        int[] next = buildNext(needle);
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] buildNext(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
