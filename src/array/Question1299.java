package array;

public class Question1299 {
    // [17,18,5,4,6,1]
    // [18,6,6,6,1,-1]
    public int[] replaceElements(int[] arr) {
        // replace starting from far right end to left end
        if (arr.length == 1)
            return new int[]{-1};

        int[] result = new int[arr.length];
        result[arr.length - 1] = -1;
        int maxFromRight = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            // 记录max: 记录从右数开始遇到的最大的数
            maxFromRight = Math.max(arr[i + 1], maxFromRight);
            result[i] = maxFromRight;
        }
        return result;
    }

    // [17,18,5,4,6,1]
    // [18,18,6,6,6,1, -1]
    public int[] replaceElements2(int[] arr) {
        // replace starting from far right end to left end
        if (arr.length == 1)
            return new int[]{-1};

        int maxFromRight = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            // 记录max: 记录从右数开始遇到的最大的数
            maxFromRight = Math.max(arr[i], maxFromRight);
            arr[i] = maxFromRight;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        ;
        arr[arr.length - 1] = -1;
        return arr;
    }
}
