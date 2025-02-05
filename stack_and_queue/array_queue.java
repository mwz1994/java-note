package stack_and_queue;

import java.util.Arrays;

class ArrayQueue{
    private int[] nums; // 用于存储队列元素的数组
    private int front; // 队首指针，指向队首元素
    private int queSize; // 队列长度

    public ArrayQueue(int size){
        this.nums = new int[size];
        this.front = 0;
        this.queSize = 0;
    }

    int capacity(){
        return nums.length;
    }

    int size(){
        return queSize;
    }

    boolean isEmpty(){
        return queSize==0;
    }

    void push(int num){
        if (queSize == capacity()){
            throw new IndexOutOfBoundsException();
        }
        var rear = (front + queSize) % capacity();
        nums[rear] = num;
        queSize = queSize+1;
    }

    int pop(){
        int head = nums[front];
        queSize--;
        front =( front + 1 ) % capacity();
        return head;
    }

    int peek(){
        return nums[front];
    }

    int[] toArray(){
        int[] arr = new int[queSize];

        for (int i = 0 , j =front; i < queSize; i++,j++) {
            arr[i] = nums[j%capacity()];
        }

        return arr;
    }
}

public class array_queue {
    public static void main(String[] args) {
        /* 初始化队列 */
        int capacity = 10;
        ArrayQueue queue = new ArrayQueue(capacity);

        /* 元素入队 */
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);
        System.out.println("队列 queue = " + Arrays.toString(queue.toArray()));

        /* 访问队首元素 */
        int peek = queue.peek();
        System.out.println("队首元素 peek = " + peek);

        /* 元素出队 */
        int pop = queue.pop();
        System.out.println("出队元素 pop = " + pop + "，出队后 queue = " + Arrays.toString(queue.toArray()));

        /* 获取队列的长度 */
        int size = queue.size();
        System.out.println("队列长度 size = " + size);

        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
        System.out.println("队列是否为空 = " + isEmpty);

        /* 测试环形数组 */
        for (int i = 0; i < 10; i++) {
            queue.push(i);
            queue.pop();
            System.out.println("第 " + i + " 轮入队 + 出队后 queue = " + Arrays.toString(queue.toArray()));
        }
    }
}
