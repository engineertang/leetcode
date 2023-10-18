package com.question119;

import com.recursion.PascalTriangle119;
import org.junit.Test;

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
        List result = p.getRow(4);
        for (Object o : result) {
            System.out.print(o + " ");
        }
    }
} 
