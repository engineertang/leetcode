package com.question21;

import com.linkedList.ListNode;
import com.linkedList.question21.Question21;
import org.junit.Test;

/** 
* MergeLinkedList Tester. 
* 
* @author donald
* @since <pre>12/07/2017</pre> 
* @version 1.0 
*/ 
public class MergeLinkedListTest {

@Test
public void testMerge2() throws Exception {
    ListNode listNode1 = new ListNode(2);
    listNode1.setNext(new ListNode(4));

    ListNode listNode2 = new ListNode(5);
    listNode2.setNext(new ListNode(8));

    Question21 mergeLinkedList= new Question21();
    ListNode listNode3 = mergeLinkedList.merge2(listNode1, listNode2);

    while(null != listNode3){
        System.out.print(listNode3.getVal());
        listNode3 = listNode3.getNext();
    }
} 


} 
