package test.question1; 

import org.junit.Test; 
import org.junit.Before;
import org.junit.After;
import question1.TwoSum;

/**
* TwoSum Tester.
*
* @author <Authors name>
* @since <pre>ʮ���� 6, 2017</pre>
* @version 1.0
*/
public class TwoSumTest {

    /**
    * Method: twoSum(int[] nums, int target)
    */
    @Test
    public void testTwoSum() throws Exception {
        TwoSum twoSum = new TwoSum();
        int[] nums2 = {2, 7, 11, 15};
        int[] result = twoSum.twoSum2(nums2, 19);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
} 
