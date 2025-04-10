/* 151. 反转字符串中的单词 */
public class Main_250410_02 {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        int n = split.length;
        for (int i = n - 1; i > 0; i--) {
            stringBuilder.append(split[i]).append(" ");
        }
        stringBuilder.append(split[0]);
        String ans = stringBuilder.toString();
        return ans;
    }
}
