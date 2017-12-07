package question9;

/**
 * Created by Administrator on 2017/12/7.
 */
public class PalindromeNumber {
    /*给定一个int数，此题关键是空间复杂需为O（1）
    思路1
    ssfsf
    思路2: revers数的方法，用除和取模的方法操作n位，能一次得到从个位到头位的数
    优化：这里增加了一个时间复杂度的优化，O(N)-->O((Log10 ^n)/2) 减半，主要是避免int的值溢出
    优化：边界问题=特殊情况，负数，返回false
    */
    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int revertedNumber = 0;
        int previousNumber = x;
        while (x > 0){
            revertedNumber = x % 10 + revertedNumber * 10;
            x = x / 10;
        }

        return previousNumber == revertedNumber;
    }

    public boolean isPalindrome2(int x){
        //compare start number with ending number with String.class method
        String s = "12321";
        int seq = 0;
        while (s.charAt(seq) == s.charAt(s.length()-1-seq) && seq < s.length()/2){
            seq ++;
        }
        /*for (int seq2 = 0; seq2 < s.length()/2; seq ++){
            if (s.charAt(seq) != s.charAt(s.length()-1-seq))   {
                return false;
            }
        }*/

        if(seq >= s.length()/2){
            return true;
        }else
             return false;
    }
}
