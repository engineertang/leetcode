package com.binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class PeakIndexInMoutainArray852Test {
    @Test
    public void peakIndexInMountainArray() {
        int[] a = {0, 6, 8, 9, 1, 5};
        PeakIndexInMoutainArray852 test = new PeakIndexInMoutainArray852();
        int smallest = test.peakIndexInMountainArray(a);
        Assert.assertEquals(smallest, 3);

    }
}