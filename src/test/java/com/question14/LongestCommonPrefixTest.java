package com.question14;

import com.string.LongestCommonPrefix14;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * LongestCommonPrefix Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/17/2017</pre>
 */
public class LongestCommonPrefixTest extends TestCase {

    /**
     * Method: getLongestCommonPrefix(String[] strs)
     */
    @Test
    public void testGetLongestCommonPrefix() throws Exception {
        LongestCommonPrefix14 longestCommonPrefix = new LongestCommonPrefix14();
        String[] strArray = {"leet", "leetcode", "levis"};
        System.out.print(longestCommonPrefix.getLongestCommonPrefix(strArray));
        Assert.assertEquals("le", longestCommonPrefix.getLongestCommonPrefix(strArray));
    }
} 
