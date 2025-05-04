import java.util.List;

/* 25. K ��һ�鷭ת���� */
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
            // ȷ����ǰ���Ƿ����㹻��k���ڵ�
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break; // ����k��������
            }

            ListNode start = pre.next;
            ListNode nextSegment = end.next;
            end.next = null; // �Ͽ���ǰ�Σ����㷭ת

            // ��ת��ǰ��
            pre.next = reverse(start);

            // ���Ӻ����ڵ㣬������pre��end
            start.next = nextSegment;
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    // ��ת���������µ�ͷ�ڵ�
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
