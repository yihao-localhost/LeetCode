import java.util.ArrayList;
import java.util.List;

/* 141. ª∑–Œ¡¥±Ì */
public class Main_250502_02 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode next = head.next;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (next != null){
            if (list.contains(next))
                return true;
            list.add(next);
            next = next.next;
        }
        return false;
    }
}
