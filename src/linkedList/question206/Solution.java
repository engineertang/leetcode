package linkedList.question206;

import java.util.Stack;

public class Solution {
    // 用栈数据结构 反转链表
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode cur = result;
        while(!stack.isEmpty()){
            cur.next = stack.pop();
            cur = cur.next;
            cur.next = null;
        }
        return result.next;
    }

    //递归  In-place iterative and recursive Java solution
    //什么是递归 难理解
    public ListNode recursionReverseList(ListNode head) {
        return null;
    }

    // 迭代 iterative 双指针
    public ListNode iterate(ListNode head) {
        if (head == null || head.next ==null){
            return head;
        }
        ListNode cur = head;
        ListNode temp = cur;
        ListNode pointter = null;
        while(cur != null){
            temp = temp.next;
            cur.next = pointter;
            pointter = cur;
            cur = temp;
        }
        return pointter;

//            pointter.next.next = pointter;
//            pointter.next = null;
//            pointter = cur;
//            cur = cur.next;

        // head  A(n-1) -> f(n)             A(n-1) <- f(n)
        //       A(n-1) -> A(n) ->  A(n+1)  A(n-1) <- A(n)  <- A(n+1)
        // head ->  head.next   交换方向
        // head <-  head.next
    }

    //构造函数 递归
    public ListNode constructor(ListNode head) {
        ListNode result = null;
        while(head != null){
            result = new ListNode(head.val, result);
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        b.next = c;
        a.next = b;
        d.next = e;
        c.next = d;

        Solution solution = new Solution();
        ListNode result =  solution.constructor(a);
        while (result !=null){
            System.out.println(String.valueOf(result.val));
            if (result.next != null){
                result=result.next;
            }else{
                break;
            }
        }
    }
}

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
