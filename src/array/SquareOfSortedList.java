package array;

// SquareOfSortedList
public class SquareOfSortedList {
    public int sortedSquares(int[] nums) {
        //return  Arrays.stream(nums).map(operand -> operand * operand).sorted().toArray();
//        return Arrays.stream(nums).filter(value -> {
//            int length = String.valueOf(value).length();
//            if (length%2 == 0){
//                return true;
//            }else
//                return false;
//        }).toArray();

        int maxLength = 0;
        int currentLength = 0;
        for (int num : nums) {
            if (num == 1) {
                currentLength++;
            } else {
                //maxLength = currentLength > maxLength ? currentLength : maxLength;
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        return currentLength > maxLength ? currentLength : maxLength;
    }


}
