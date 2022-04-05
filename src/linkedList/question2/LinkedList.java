package linkedList.question2;

/**
 * Created by Administrator on 2017/12/6.
 * 链表相加
 */
public class LinkedList {

    public ListNode addTwoSum(ListNode list1, ListNode list2){
        ListNode resultNode = new ListNode(0);
        ListNode p = list1;
        ListNode q = list2;
        ListNode cur = resultNode;
        int carry = 0;
        while(null != p || null != q ) {
            int x = (null == p ? 0 : p.value);
            int y = (null == q ? 0 : q.value);
            int sum = x + y + carry;
            carry = sum / 10;

            cur.next = new ListNode( sum % 10);
            cur = cur.next;

            if(null != p) p = p.next;
            if(null != q) q = q.next;
        }

        return  resultNode;
    }



}

