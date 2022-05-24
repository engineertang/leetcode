package binarySearch;

public class SquarRoot69 {

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        // 用二分查找逐步逼近，   1 ~ x/2
        // 考虑边界值， x =0, x=1, x=2
        int from = 1, to = x / 2;

        // 逼近target=x, 与middle.square比较
        // 例如求100的平方根，在1 ~ 50之间找， 25.square > 100, 在1 ~ 24之间找，12.square > 100, 在1~11之间找， 6.squre < 100, 在7~11之间找， 9.square < 100, 在10~11之间找，10
        // 求8的平方根，在1~4之间找，2*2 < 8, 在3~4之间找， 3*3>8, 在3~3之间找
        //  1 ~ middle ~ x/2
        while (from <= to) {
            // 等于(left + right) / 2, 利用减法代替加法避免溢出
            int middle = from + (to - from) / 2;
            // 两边*mid后: x = mid * mid , 利用除法代替乘法避免溢出
            if (x / middle == middle) {
                return middle;
            } else if (x / middle < middle) {// 在上半部分
                to = middle - 1;
            } else if (x / middle > middle) {// 在下半部分
                from = middle + 1;
            }
        }

        return from - 1;
    }

    public static void main(String[] args) {
        SquarRoot69 question69 = new SquarRoot69();
        System.out.println(question69.mySqrt(5));
    }
}
