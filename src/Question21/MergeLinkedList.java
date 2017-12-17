package question21;

import question2.ListNode;

/**
 * Created by Administrator on 2017/12/7.
 */
public class MergeLinkedList {
    /*public LinkedList merge(LinkedList l1, LinkedList l2){
        ListIterator<Integer> iterator1 = l1.listIterator();
        ListIterator<Integer> iterator2 = l2.listIterator();
        LinkedList<Integer> resultList = new LinkedList<>();
        while(iterator1.next() < iterator2.next()){
            resultList.addFirst(iterator1.next());
            return
        }
            iterator1.next()
    }*/

    public ListNode merge2(ListNode l1, ListNode l2){
        if(null != l1 && null == l2) {
            return l1;
        }
        if(null == l1 && null != l2){
            return l2;
        }
        if(null == l1 && null == l2){
            return null;
        }
        if(l1.getValue() <= l2.getValue()){
            l1.setNext(merge2(l1.getNext(), l2));
            return l1;
        }else if(l1.getValue() > l2.getValue()){
            l2.setNext(merge2(l1, l2.getNext()));
            return l2;
        }
        return null;
    }
}
