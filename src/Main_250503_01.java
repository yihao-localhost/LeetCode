import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* 21. 合并两个有序链表 */
public class Main_250503_01 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode ans = list;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ans.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null) {
                ans.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                ans.next = new ListNode(list1.val);
                list1 = list1.next;
            } else /*if (list2.val <= list1.val)*/ {
                ans.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            ans = ans.next;
        }
        return list.next;
    }
}
