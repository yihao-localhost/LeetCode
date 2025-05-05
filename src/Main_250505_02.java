import java.util.List;

/* 86. ∑÷∏Ù¡¥±Ì */
public class Main_250505_02 {
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

      public ListNode partition(ListNode head, int x) {
            if (head == null)
                  return null;
            ListNode ans = new ListNode(-1);
            ListNode left = ans;
            ListNode rightHead = new ListNode(-1);
            ListNode right = rightHead;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            dummy = dummy.next;
            while (dummy != null) {
                  if (dummy.val < x) {
                        left.next = new ListNode(dummy.val);
                        left = left.next;
                  } else {
                        right.next = new ListNode(dummy.val);
                        right = right.next;
                  }
                  dummy = dummy.next;
            }
            left.next = rightHead.next;
            return ans.next;
      }
}
