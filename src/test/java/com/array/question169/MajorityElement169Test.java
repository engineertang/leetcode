package com.array.question169;

import com.array.MajorityElement169;
import org.junit.Assert;
import org.junit.Test;

public class MajorityElement169Test {

    @Test
    public void majorityElement() {
    }

    @Test
    public void binarySearch() {
        int[] array = new int[]{2,2,3,3,4,4,4,4,4};
        MajorityElement169 majorityElement169 = new MajorityElement169();
        Assert.assertEquals(majorityElement169.binarySearch(array), 4);
        System.out.println(majorityElement169.binarySearch(array));
    }
}