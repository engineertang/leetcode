package recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

public class ReversedPrintLinkList {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        if (head == null)
            return null;
        recurse(head, list);

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    void recurse(ListNode head, List list) {
        //recursion递归
        //base condition
        if (head.next == null) {
            list.add(head.val);
            return;
        }
        recurse(head.next, list);

        list.add(head.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l3.next = l2;
        l1.next = l3;

        ReversedPrintLinkList r = new ReversedPrintLinkList();
        int[] result = r.reversePrint(l1);
        Arrays.stream(result).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }

}
