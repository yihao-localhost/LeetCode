import java.net.HttpURLConnection;
import java.util.Arrays;

/* 14. 最长公共前缀 */
public class Main_250410_01 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "" ;
        }
        // 找到数组中最短的字符串长度
        String min = "";
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLength) {
                minLength = s.length();
                min = s;
            }
        }
        // 如果最短字符串长度为0，直接返回空字符串
        if (minLength == 0) {
            return "";
        }
        String ans = "";
        for (int i = 0; i < minLength + 1; i++) {
            boolean flag = true;
            char[] minPre = new char[minLength];
            min.getChars(0, i, minPre, 0);
            for (String str : strs) {
                char[] temp = new char[minLength];
                str.getChars(0, i, temp, 0);
                if (!Arrays.equals(minPre, temp)) {
                    return ans;
                }
            }
            ans = new String(minPre, 0, i);
        }
        System.out.println("ans = " + ans);
        return ans;
    }

    public static void main(String[] args) {
        new Main_250410_01().longestCommonPrefix(new String[]{"a"});
    }
}
