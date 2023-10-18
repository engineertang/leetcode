package com.question2;

import com.linkedList.ListNode;
import com.linkedList.question2.LinkedList;
import org.junit.Test;

/** 
* LinkedList Tester. 
* 
* @author donald
* @since <pre>12/06/2017</pre> 
* @version 1.0 
*/ 
public class LinkedListTest { 

@Test
public void testAddTwoSum() throws Exception {
    ListNode listNode1 = new ListNode(2);
    listNode1.setNext(new ListNode(4));

    ListNode listNode2 = new ListNode(5);
    listNode2.setNext(new ListNode(8));

    LinkedList linkedList = new LinkedList();
    ListNode listNode3 = linkedList.addTwoSum(listNode1, listNode2);

    while(null != listNode3){
        System.out.print(listNode3.getVal());
        listNode3 = listNode3.getNext();
    }


} 


} 
