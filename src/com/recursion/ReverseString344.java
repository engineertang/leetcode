package com.recursion;

public class ReverseString344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public void reverseString2(char[] s) {
        char[] chars = new char[s.length];
        helper(0, s, chars);

        for (int i = 0; i < s.length; i++) {
            s[i] = chars[i];
        }
    }

    public void helper(int index, char[] s, char[] chars) {
        if (index > s.length - 1)
            return;
        helper(index + 1, s, chars);
        chars[s.length - 1 - index] = s[index];
    }

    public void helper2(int index, char[] s) {
        if (index > (s.length - 1) / 2)
            return;
        helper2(++index, s);
        //swap(s,index);
        char temp = s[index];
        s[index] = s[s.length - 1 - index];
        s[s.length - 1 - index] = temp;
    }
}
