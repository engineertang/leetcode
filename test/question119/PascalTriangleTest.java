package question119;

import recursion.question119.PascalTriangle;
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
        PascalTriangle p = new PascalTriangle();
        List result = p.getRow(4);
        for (Object o : result) {
            System.out.print(o + " ");
        }
    }
} 
