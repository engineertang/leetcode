package com.binarySearch;

public class SearchMatrix {
    // 二分查找的时间复杂度是O(N*log2N)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int minRow=0, minColumn = 0;
        int maxRow = row -1, maxColumn = column-1;

        while (minRow <= maxRow){
            // 中心点值 == target
            int midRow = (minRow + maxRow)/2;
            int midColumn = (minColumn + maxColumn)/2;

            if(matrix[midRow][midColumn] == target){
                return true;
            }else if(matrix[midRow][midColumn] > target){
                return false;
            }
                // 中心点值 > target, 左上角
                // 中心点值 < target， 其余位置
        }
        return false;
    }

}
