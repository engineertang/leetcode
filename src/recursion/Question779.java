package recursion;

public class Question779 {

    public int kthGrammar(int n, int k) {
        // recurse relation

        //base case
        return 0;
    }

    String helper(int n) {
        if (n == 1) {
            return "0";
        }
        String buffer = helper(n - 1);
        buffer.replaceAll("0", "01");
        buffer.replaceAll("1", "10");

        return "";
    }
}
