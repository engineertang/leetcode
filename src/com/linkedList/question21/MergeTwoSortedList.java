package com.linkedList.question21;

import com.linkedList.ListNode;

public class MergeTwoSortedList {
    // two pointer,  linkedList的插入操作, iterative 迭代
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        ListNode result = new ListNode();
        ListNode cur = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.val = list1.val;
                cur.next = new ListNode();

                cur = cur.next;

                list1 = list1.next;
            } else {
                //把list2插到list1前面
                cur.val = list2.val;
                cur.next = new ListNode();
                cur = cur.next;

                list2 = list2.next;
            }
        }

        while (list1 == null && list2 != null) {
            cur.val = list2.val;
            if (list2.next != null) {
                cur.next = new ListNode();
                cur = cur.next;
            }
            list2 = list2.next;
        }

        while (list1 != null) {
            cur.val = list1.val;
            if (list1.next != null) {
                cur.next = new ListNode();
                cur = cur.next;
            }

            list1 = list1.next;
        }

        return result;
    }

    //递归  或 while
        /*1.把问题规模变小 f(x) = f(x-1)
          2.求f(1), f(2)
          merge(list1, list2)=
            list1.value <= list2.value
                result.value = list1.value;
                result.next = merge(list1.next, list2);
            list1.value > list2.value
                result = list.value
                result.next = merge(list1, list2.next);


          merge(list1, null) return list1;
          merge(null, list2) return list2;
        */

    //recursion递归
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list2 == null)
            return list1;
        if (list1 == null)
            return list2;

        ListNode current = new ListNode();
        if (list1.val <= list2.val) {
            current.val = list1.val;
            current.next = merge(list1.next, list2);
        }

        if (list1.val > list2.val) {
            current.val = list2.val;
            current.next = merge(list1, list2.next);
        }

        return current;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        b.next = c;
        a.next = b;

        ListNode x = new ListNode(1);
        ListNode y = new ListNode(3);
        ListNode z = new ListNode(4);
        y.next = z;
        x.next = y;
        ListNode result = merge(a, x);

        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);
    }
}


