package com.linkedList.question206;

import com.linkedList.ListNode;

import java.util.Stack;

public class ReverseList {
    // 方法一：用栈数据结构 反转链表
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode result = new ListNode();
        ListNode cur = result;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
            cur.next = null;
        }
        return result.next;
    }

    //  方法二：迭代 iterative 双指针
    public ListNode iterate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode temp = cur;
        ListNode pointter = null;
        while (cur != null) {
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

    // 方法三：递归  recursive Java solution

    /**
     * Recurrence Relation
     * Let's start with the recurrence relation within the Pascal's Triangle.
     * First of all, we define a function f(i, j) which returns the number in the Pascal's Triangle in the i-th row and j-th column.
     * <p>
     * We then can represent the recurrence relation with the following formula:
     * f(i, j) = f(i - 1, j - 1) + f(i - 1, j)
     * <p>
     * Base Case
     * As one can see, the leftmost and rightmost numbers of each row are the base cases in this problem, which are always equal to 1.
     * As a result, we can define the base case as follows:
     * <p>
     * 1. Recurrence Relation
     * we define a function f(ListNode) reversed ListNode
     * <p>
     * We then can represent the recurrence relation with the following formula:
     * f(listNode) =  f(lisNode.next) -> listNode
     * <p>
     * = f(listNode.next.next) -> listNode.next -> listNode
     * <p>
     * =  f(listNode.next.next) -> listNode.next.next -> listNode.next -> listNode
     * A[3]                 A[2]     ->    A[1]
     * (A[n-1] -> A[n])
     * A[n] -> A(n-1)
     * ...
     * <p>
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 <- 2 <- 3 <- 4 <- 5
     * <p>
     * 2.Base Case
     * listNode == null, then return null
     * listNode.next == null, then return listNode
     */
    public ListNode reverseList2(ListNode head) {
        ListNode tail = recursionReverseList(head);
        return head;
    }

    public ListNode recursionReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextReverse = recursionReverseList(head.next);

        head.next = null;
        ListNode cur = nextReverse;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;

        return nextReverse;
    }


    // 方法四：构造函数 递归
    public ListNode constructor(ListNode head) {
        ListNode result = null;
        while (head != null) {
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
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ReverseList reverseList = new ReverseList();
        ListNode result = reverseList.recursionReverseList(a);
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

