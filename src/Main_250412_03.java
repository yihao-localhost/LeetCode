/* 125. 验证回文串 */
public class Main_250412_03 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        String clean = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Main_250412_03().isPalindrome("A man, a plan, a canal: Panama"));
    }
}