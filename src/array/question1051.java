package array;

import java.util.Arrays;

public class question1051 {
    //Build the correct order of heights by sorting another array,
    // then compare the two arrays.
    public int heightChecker(int[] heights) {
        int[] originalArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int differ = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != heights[i]) {
                differ++;
            }
        }

        return differ;
    }
}
