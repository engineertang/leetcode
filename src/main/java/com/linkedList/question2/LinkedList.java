package com.linkedList.question2;

import com.linkedList.ListNode;

/**
 * Created by Administrator on 2017/12/6.
 * 链表相加 question
 */
public class LinkedList {
    public ListNode addTwoSum(ListNode p, ListNode q) {
        ListNode resultNode = new ListNode(0);

        ListNode cur = resultNode;
        int carry = 0;
        while (null != p || null != q) {
            int x = (null == p ? 0 : p.getVal());
            int y = (null == q ? 0 : q.getVal());
            int sum = x + y + carry;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (null != p) p = p.next;
            if (null != q) q = q.next;
        }
        return resultNode;
    }

    public ListNode addTwoNumbers(ListNode p, ListNode q) {
        ListNode cur = new ListNode(0);
        ListNode dumb = cur;

        int carry = 0;
        while (null != p || null != q) {
            int x = (null == p ? 0 : p.val);
            int y = (null == q ? 0 : q.val);
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode next = new ListNode(sum % 10);

            cur.next = next;
            cur = cur.next;

            if (null != p) p = p.next;
            if (null != q) q = q.next;
        }
        if (carry!=0){
            ListNode next = new ListNode(carry);

            cur.next = next;
        }
        return dumb.next;
    }
}

