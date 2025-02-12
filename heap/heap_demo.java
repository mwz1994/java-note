package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class heap_demo {
    public static void main(String[] args) {

        /* 初始化堆 */
// 初始化小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
// 初始化大顶堆（使用 lambda 表达式修改 Comparator 即可）
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        /* 元素入堆 */
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);

        /* 元素入堆 */
        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(3);
        minHeap.offer(2);
        minHeap.offer(5);
        minHeap.offer(4);

        Integer poll;
        /* 获取堆顶元素 */
        int peek = maxHeap.peek(); // 5

        /* 堆顶元素出堆 */
// 出堆元素会形成一个从大到小的序列

        do {
            poll = minHeap.poll();
            System.out.println("minHeap poll is "+ poll);
        }while (poll != null);

        /* 获取堆大小 */
        int size = maxHeap.size();

        System.out.println("max heap size "+ size);

        /* 判断堆是否为空 */
        boolean isEmpty = maxHeap.isEmpty();

        /* 输入列表并建堆 */
        minHeap = new PriorityQueue<>(Arrays.asList(1, 3, 2, 5, 4));
    }
}
