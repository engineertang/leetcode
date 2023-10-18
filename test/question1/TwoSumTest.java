package question1;

import com.array.question1.TwoSum;
import org.junit.Test;

/**
* TwoSum Tester.
*
* @author <Authors name>
* @since <pre>12/06/2017</pre>
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
        int[] result = twoSum.twoSum2(nums2, 18);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
} 
