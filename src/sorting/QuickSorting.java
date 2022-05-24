package sorting;

import java.util.Arrays;

public class QuickSorting {
    // double pointer 双指针

    /**
     * 快速排序算法有两个核心点，分别为 哨兵划分 和 递归 。
     * 1.哨兵划分：
     * 以数组某个元素（一般选取首元素）为 基准数 ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。
     * <p>
     * 2.递归：
     * 对 左子数组 和 右子数组 分别递归执行 哨兵划分，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序。
     * 如下图所示，为示例数组 [2,4,1,0,3,5] 的快速排序流程。观察发现，快速排序和 二分法 的原理类似，都是以 \loglog 时间复杂度实现搜索区间缩小。
     */

    //public void quickSort(int[] nums, int left, int right){ // 包含left与right
    // 子数组长度为 1 时终止递归


    //一次哨兵划分,以数组某个元素（一般选取首元素）为 基准数 ，
    // 循环双指针, 返回基准的序号
    // 包含left and right, sorting nums between left and right.
    public void quickSort(int[] nums, int left, int right) {
        //终止递归
        if (left >= right) {
            return;
        }

        int middle = shaobing(nums, left, right);
        quickSort(nums, left, middle - 1);
        quickSort(nums, middle + 1, right);
    }

    public int shaobing(int[] nums, int left, int right) {
        int baseIndex = left; //nums[baseIndex];

        while (left < right) {
            while (left < right && nums[right] >= nums[baseIndex]) {
                right--;
            }
            while (left < right && nums[left] <= nums[baseIndex]) {
                left++;
            }
            //交换 nums[left] nums[right]
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        // left == right
        //确定基准数到了正确的位置
        int tmp = nums[baseIndex];
        nums[baseIndex] = nums[left];
        nums[left] = tmp;

        return left;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 5, 1, -1, -3};
        QuickSorting insertionSorting = new QuickSorting();
        insertionSorting.quickSort(array, 0, array.length - 1);

        Arrays.stream(array).forEach(value -> System.out.printf(Integer.toString(value)));
    }
}
