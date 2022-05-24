package question26;

import array.question26.RemoveElement;
import org.junit.Test;

/** 
* RemoveElement Tester. 
* 
* @author donald
* @since <pre>12/17/2017</pre> 
* @version 1.0 
*/ 
public class RemoveElementTest { 
/**
* 
* Method: removeElement(int[] nums, int val) 
* 
*/ 
@Test
public void testRemoveElement() throws Exception {
    RemoveElement removeElement = new RemoveElement();
    int[] intArray = {3,2,3,9,7};
    System.out.println(removeElement.removeElement(intArray, 3));

} 


} 
