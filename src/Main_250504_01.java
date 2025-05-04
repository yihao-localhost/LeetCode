import java.util.List;

/* 25. K 个一组翻转链表 */
public class Main_250504_01 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 确定当前段是否有足够的k个节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break; // 不足k个，结束
            }

            ListNode start = pre.next;
            ListNode nextSegment = end.next;
            end.next = null; // 断开当前段，方便翻转

            // 翻转当前段
            pre.next = reverse(start);

            // 连接后续节点，并更新pre和end
            start.next = nextSegment;
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    // 翻转链表，返回新的头节点
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
