package com.question119;

import com.recursion.PascalTriangle119;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/** 
* PascalTriangle Tester. 
* 
* @author donald
* @since <pre>12/17/2017</pre> 
* @version 1.0 
*/ 
public class PascalTriangleTest {
/**
* Method: getRow(int rowIndex)
*/ 
    @Test
    public void testGetRow() throws Exception {
        PascalTriangle119 p = new PascalTriangle119();
        List<Integer> result = p.getRow(5);
        for (Object o : result) {
            System.out.println(o + " ");
        }
        /**
         * 1, 4, 6, 4, 1
         */
        Assert.assertArrayEquals(new Integer[]{1, 5, 10, 10, 5, 1}, result.toArray(new Integer[0]));
    }
} 
