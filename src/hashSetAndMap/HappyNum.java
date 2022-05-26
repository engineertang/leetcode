package hashSetAndMap;

import java.util.HashSet;

public class HappyNum {
    public boolean isHappy(int n) {
        //犹如是快乐数的话，它就会有一个死循环，也就是比如99它计算以后是162，162以后是41，它又回来了，就是又比99小了
        //循环以后，如果没有等于一那么就不是快乐数,这个时候就是一个死循环
        HashSet<Integer> integers = new HashSet<>();
        //这里是得到给定一个数的下一个拆解平方数
        int result=0;
        while(true){
            result = getSquare(n);
            if(result==1){
                return true;
            }
            //如果不是快乐数就会在hastset里面有这个数字了，那么他就不是快乐数
            if(integers.contains(result)){
                return false;
            }
            //如果没有进入循环就加入这个数字
            integers.add(result);
            n=result;
        }
    }

    private static int getSquare(int n) {
        String target=n+"";
        char[] chars = target.toCharArray();
        int sum=0;
        for (int i = 0; i <chars.length ; i++) {
            sum+=Math.pow(Integer.parseInt(String.valueOf(chars[i])),2);
        }
        return sum;
    }

    public boolean isHappy2(int n) {
        int cur = n, count = 1000;
        while(cur != 1 && count > 0){
            // 将数转化成int[], 并求平方和
            int sum = 0;
            while(cur > 0){
                sum += Math.pow((cur%10), 2);
                cur = cur/10;
            }
            count --;
            if(sum == 1){
                return true;
            }else {
                cur = sum;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HappyNum happyNum = new HappyNum();
        System.out.println(happyNum.isHappy(19));
    }
}
