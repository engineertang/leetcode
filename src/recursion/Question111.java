package recursion;

import java.util.Arrays;
import java.util.Stack;

public class Question111 {
    // 递归  f(n) = n + f(n-1)
    //  f(1)
    public int[] reversePrint(ListNode head) {
        while (head == null) {
            return new int[0];
        }
        while (head.next == null) {
            return new int[]{head.val};
        }
        int[] last = reversePrint(head.next);
        int[] cur = Arrays.copyOf(last, last.length + 1);
        cur[last.length] = (head.val);
        return cur;
    }

    // 反转链表
    public ListNode reverseLink(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return head;
    }

    /* 使用栈来解决
    从尾到头打印链表，首先这个链表是单向的，如果是双向的，直接从后往前打印就行了，这里链表不是单向的。
    这里最容易想到的一种方式就是把链表的节点全部压栈，因为栈是先进后出的一种数据结构，全部压栈之后再一个个出栈即可，*/
    public int[] stack(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
