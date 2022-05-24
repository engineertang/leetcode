package stack;

import org.junit.Assert;
import org.junit.Test;
import stack.question20.MyStack;

public class Stack20Test {

    @Test
    public void isValid() {
        MyStack stack20 = new MyStack();
        Boolean result = stack20.isValid("(])");
        Assert.assertEquals(result, false);
    }
}