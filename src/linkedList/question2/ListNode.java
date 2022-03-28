package linkedList.question2;

/**
 * Created by Administrator on 2017/12/6.
 */
public class ListNode {

    int value;
    ListNode next;
    public ListNode(){};
    public ListNode(int x){
        this.value = x;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}