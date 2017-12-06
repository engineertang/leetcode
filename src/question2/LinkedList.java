package question2;

/**
 * Created by Administrator on 2017/12/6.
 */
public class LinkedList {

    public ListNode addTwoSum(ListNode list1, ListNode list2){
        ListNode listNode = new ListNode(0);
        ListNode p = list1.next;
        ListNode q = list2.next;
        ListNode cur = listNode;
        int carry = 0;
        while(null != p || null != q ) {
            int x = null == p ? 0 : p.value;
            int y = null == q ? 0 : q.value;
            int sum = x + y;
            carry = sum / 10;
            listNode.value = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(null != p.next) p = p.next;
            if(null != q.next) q = q.next;
        }

        return  listNode;
    }



}

