package recursion;

import linkedList.ListNode;

public class Question24 {
    public ListNode swapPairs(ListNode head) {
        ListNode next = swap(head);
        return next;
    }

    // recursion relation 递归公式  A(n)  A(n-1)
    ListNode swap(ListNode listNode) {
        // bottom case
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        // list  next
        /** a1 -> a2 -> a3 -> a4 -> a5 -> a6 -> a7
         *  swap(a1)
         *             swap(a3)
         *             a2 -> a1
         *             a1 -> swap(a3)
         *                        swap(a5)
         *                                    swap(a7)
         *
         *
         */
        ListNode next = listNode.next;
        ListNode nextSwap = next.next;
        next.next = listNode;

        ListNode nextResult = swap(nextSwap);
        listNode.next = nextResult;
        return next;
    }
}
