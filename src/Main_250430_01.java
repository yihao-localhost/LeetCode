import java.util.ArrayDeque;
import java.util.Deque;

/* 71. ¼ò»¯Â·¾¶ */
public class Main_250430_01 {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if (name.isEmpty() || name.equals(".")) {
                continue;
            }else if (!name.equals("..")) {
                stack.push(name);
            }else if (!stack.isEmpty()){
                stack.pop();
            }
        }
        Deque<String> ans = new ArrayDeque<>();
        for (String s : stack) {
            ans.push(s);
            stack.pop();
        }
        return "/" + String.join("/", ans);
    }
}
