package com.question9;

import org.junit.Assert;
import org.junit.Test;
import com.string.PalindromeNumber9;

/**
 * PalindromeNumber Tester.
 *
 * @author donald
 * @version 1.0
 * @since <pre>12/07/2017</pre>
 */
public class PalindromeNumber9Test {

    /**
     * Method: isPalindrome(int x)
     */
    @Test
    public void testIsPalindrome() throws Exception {

        PalindromeNumber9 palindromeNumber9 = new PalindromeNumber9();
        System.out.print(palindromeNumber9.isPalindrome2(3000000));
        Assert.assertTrue(palindromeNumber9.isPalindrome2(3000000));
    }
} 
