/* 82. 删除排序链表中的重复元素 II */
public class Main_250504_03 {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode prev = dummy;
        int curVal;
        boolean flag;
        while (cur != null) {
            flag = false;
            curVal = cur.val;
            ListNode next = cur.next;
            while (next != null && curVal == next.val) {
                flag = true;
                next = next.next;
            }
            if (flag) {
                prev.next = next;
            } else {
                prev = prev.next;
            }

            cur = prev.next;
        }
        return dummy.next;
    }
}
