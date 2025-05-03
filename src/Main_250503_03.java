import java.util.ArrayList;
import java.util.List;

/* 92. ��ת���� II */
public class Main_250503_03 {
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // ����һ��dummyHead, ���㴦��
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // ��ʼ��ָ��
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // ��ָ���Ƶ���Ӧ��λ��
        for(int step = 0; step < m - 1; step++) {
            g = g.next; p = p.next;
        }

        // ͷ�巨����ڵ�
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }
}
