import java.util.*;

/* 20. ÓÐÐ§µÄÀ¨ºÅ */
public class Main_250429_02 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }else if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
                return false;
            }
        }
        return !stack.isEmpty();
    }
}
