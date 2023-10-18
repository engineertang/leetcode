package com.string;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString344Test {

    @Test
    public void reverseStringTest() {
        ReverseString344 helper = new ReverseString344();
        String t = "Hello World";
        char[] chars = t.toCharArray();
        helper.reverseString(chars);
        System.out.printf(String.valueOf(chars));
        Assert.assertEquals("dlroW olleH", String.valueOf(chars));
    }

}