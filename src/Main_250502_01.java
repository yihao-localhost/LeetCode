import java.util.Deque;
import java.util.LinkedList;

/* 224. »ù±¾¼ÆËãÆ÷ */
public class Main_250502_01 {
    public int calculate(String s) {
        Deque<Integer> options = new LinkedList<Integer>();
        options.push(1);
        int flag = 1;

        int ans = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                flag = options.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                flag = -options.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                options.push(flag);
                i++;
            } else if (s.charAt(i) == ')') {
                options.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += flag * num;
            }
        }
        return ans;
    }
}
