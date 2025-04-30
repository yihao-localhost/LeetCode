import java.util.*;

/* 150. 逆波兰表达式求值 */
public class Main_250430_03 {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>(List.of(new String[]{"+", "-", "*", "/"}));
        for (String s : tokens) {
            if (set.contains(s)){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                switch (s){
                    case "+":
                        stack.push(String.valueOf(a+b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a-b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a*b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a/b));
                        break;
                }
            }else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
