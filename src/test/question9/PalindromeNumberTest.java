package test.question9; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import question9.PalindromeNumber;

/** 
* PalindromeNumber Tester. 
* 
* @author donald
* @since <pre>12/07/2017</pre> 
* @version 1.0 
*/ 
public class PalindromeNumberTest {

/** 
* 
* Method: isPalindrome(int x) 
* 
*/ 
@Test
public void testIsPalindrome() throws Exception { 

    PalindromeNumber palindromeNumber = new PalindromeNumber();
    System.out.print(palindromeNumber.isPalindrome2(3000000));

} 


} 
