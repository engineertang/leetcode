package com.question2;

import com.linkedList.ListNode;
import com.linkedList.AddTwoSum2;
import org.junit.Test;

/**
 * LinkedList Tester.
 *
 * @author donald
 * @version 1.0
 * @since <pre>12/06/2017</pre>
 */
public class AddTwoSum2Test {

    @Test
    public void testAddTwoSum() throws Exception {
        ListNode listNode1 = new ListNode(2);
        listNode1.setNext(new ListNode(4));

        ListNode listNode2 = new ListNode(5);
        listNode2.setNext(new ListNode(8));

        AddTwoSum2 linkedList = new AddTwoSum2();
        ListNode listNode3 = linkedList.addTwoSum(listNode1, listNode2);

        while (null != listNode3) {
            System.out.print(listNode3.getVal());
            listNode3 = listNode3.getNext();
        }


    }


} 
