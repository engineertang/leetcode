package com.question26;

import org.junit.Test;
import com.array.question26.RemoveDuplicatesFromSortedArray;

/**
 * RemoveDuplicatesFromSortedArray Tester.
 *
 * @author donald
 * @version 1.0
 * @since <pre>12/17/2017</pre>
 */
public class RemoveDuplicatesFromSortedArrayTest {


    /**
     * Method: removeDuplicates(int[] nums)
     */
    @Test
    public void testRemoveDuplicates() throws Exception {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] intArray = {1, 2, 2};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(intArray));
    }


} 
