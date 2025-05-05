/* 61. Ðý×ªÁ´±í */
public class Main_250505_01 {
    public class ListNode {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode f = dummy.next;
        int len = 1;
        while (f.next != null) {
            len++;
            f = f.next;
        }
        f.next = dummy.next;
        int num = k % len;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < len - 1; j++) {
                dummy.next = dummy.next.next;
            }
        }
        f = dummy.next;
        while (f.next != dummy.next) {
            f = f.next;
        }
        f.next = null;
        return dummy.next;
    }
}
