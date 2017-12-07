package test.question2; 

import org.junit.Test;
import question2.LinkedList;
import question2.ListNode;

/** 
* LinkedList Tester. 
* 
* @author donald
* @since <pre>12/06/2017</pre> 
* @version 1.0 
*/ 
public class LinkedListTest { 

/** 
* 
* Method: addTwoSum(ListNode list1, ListNode list2) 
* 
*/ 
@Test
public void testAddTwoSum() throws Exception {
    ListNode listNode1 = new ListNode(2);
    listNode1.setNext(new ListNode(4));

    ListNode listNode2 = new ListNode(5);
    listNode2.setNext(new ListNode(8));

    LinkedList linkedList = new LinkedList();
    ListNode listNode3 = linkedList.addTwoSum(listNode1, listNode2);

    while(null != listNode3){
        System.out.print(listNode3.getValue());
        listNode3 = listNode3.getNext();
    }
} 


} 
