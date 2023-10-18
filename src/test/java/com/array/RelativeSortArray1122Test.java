package com.array;

import com.array.RelativeSortArray1122;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RelativeSortArray1122Test {

    @Test
    public void relativeSortArray() {
        int[] arr1 = {28, 6, 22, 8, 44, 17};
        int[] arr2 = {22, 28, 8, 6};

        RelativeSortArray1122 clas = new RelativeSortArray1122();
        int[] result = clas.relativeSortArray(arr1, arr2);
        Assert.assertArrayEquals(new int[]{22, 28, 8, 6, 17, 44}, result);
        Arrays.stream(arr1).forEach(value -> System.out.printf(value + ", "));
    }
}