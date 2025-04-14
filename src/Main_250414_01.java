/* 392. еп╤овспРап */
public class Main_250414_01 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < t.length()) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
                if (j == s.length()) return true;
            }
            i++;
        }
        return false;
    }
}
