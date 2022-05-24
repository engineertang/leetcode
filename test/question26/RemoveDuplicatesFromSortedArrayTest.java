package question26;

import org.junit.Test;
import array.question26.RemoveDuplicatesFromSortedArray;

/** 
* RemoveDuplicatesFromSortedArray Tester. 
* 
* @author donald
* @since <pre>12/17/2017</pre> 
* @version 1.0 
*/ 
public class RemoveDuplicatesFromSortedArrayTest { 


/** 
* 
* Method: removeDuplicates(int[] nums) 
* 
*/ 
@Test
public void testRemoveDuplicates() throws Exception {
    RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
    int[] intArray = {1,2,2};
    System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(intArray));
} 


} 
