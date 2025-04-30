import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/* 155. ×îÐ¡Õ» */
public class Main_250430_02 {
    Deque<Integer> stack;
    Deque<Integer> min;
    public Main_250430_02() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min.push(Math.min(min.peek(), val));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
