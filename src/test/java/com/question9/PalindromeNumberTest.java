package com.question9;

import org.junit.Assert;
import org.junit.Test;
import com.string.question9.PalindromeNumber;

/** 
* PalindromeNumber Tester. 
* 
* @author donald
* @since <pre>12/07/2017</pre> 
* @version 1.0 
*/ 
public class PalindromeNumberTest {

/**
* Method: isPalindrome(int x)
*/ 
@Test
public void testIsPalindrome() throws Exception { 

    PalindromeNumber palindromeNumber = new PalindromeNumber();
    System.out.print(palindromeNumber.isPalindrome2(3000000));
    Assert.assertTrue(palindromeNumber.isPalindrome2(3000000));
} 


} 
