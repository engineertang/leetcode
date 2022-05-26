package linkedList;

public class ReverseLinkedlist {
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp_next = head.next;
        ListNode next = head.next;
        ListNode previous = head;

        while (next.next != null) {
            temp_next = next.next;
            next.next = previous;
            previous = next;
            next = temp_next;
        }
        next.next = previous;
        head.next = null;
        return next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        //ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        //d.next = e;

        ReverseLinkedlist solution = new ReverseLinkedlist();
        ListNode result = solution.reverse(a);
        while (result != null) {
            System.out.println(String.valueOf(result.val));
            if (result.next != null) {
                result = result.next;
            } else {
                break;
            }
        }
    }
}
