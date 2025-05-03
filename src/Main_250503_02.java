import java.util.HashMap;
import java.util.Map;

/* 138. 随机链表的复制 */
public class Main_250503_02 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node clone = map.get(cur);
            clone.next = map.get(cur.next);
            clone.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
