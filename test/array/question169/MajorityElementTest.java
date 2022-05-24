package array.question169;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {

    @Test
    public void majorityElement() {
    }

    @Test
    public void binarySearch() {
        int[] array = new int[]{2,2,3,3,4,4,4,4,4};
        MajorityElement majorityElement = new MajorityElement();
        Assert.assertEquals(majorityElement.binarySearch(array), 4);
        System.out.println(majorityElement.binarySearch(array));
    }
}