package heap;

// 最大堆完整代码
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        // 创建一个最大堆实例
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 分别往最大堆中添加1，3，2
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);
        // 查看最大堆的所有元素， 结果为：[3,1,2]
        System.out.println("maxHeap: "+maxHeap.toString());
        // 获取最大堆的堆顶元素
        int peekNum = maxHeap.peek();
        // 结果为：3
        System.out.println("peek number: "+peekNum);
        // 删除最大堆的堆顶元素
        int pollNum = maxHeap.poll();
        // 结果为：3
        System.out.println("poll number: "+pollNum);
        // 查看删除3后最大堆的堆顶元素，结果为：2
        System.out.println("peek number: "+maxHeap.peek());
        // 查看最大堆的所有元素，结果为：[2,1]
        System.out.println("minHeap: "+maxHeap.toString());
        // 获取最大堆的元素个数，也是最大堆的长度
        int heapSize = maxHeap.size();
        // 结果为：2
        System.out.println("maxHeap size: "+heapSize);
        // 判断最大堆是否还有元素
        boolean isEmpty = maxHeap.isEmpty();
        // 结果为：false
        System.out.println("isEmpty: "+isEmpty);
    }
}