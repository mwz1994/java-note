package stack_and_queue;

import utils.ListNode;

import java.lang.reflect.InaccessibleObjectException;
import java.util.Arrays;



class LinkedListQueue{

    ListNode front, rear;
    int queSize;

    public LinkedListQueue(){
        front = null;
        rear = null;
    }

    public void push(int item){
        ListNode nd = new ListNode(item);
        if (front == null){
            front = nd;
            front.next = rear;
        }else {
            rear.next = nd;
        }
        rear = nd;
        queSize++;
    }

    public int pop(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        var pop = front;
        front = front.next;
        queSize--;
        return pop.val;
    }

    public int peek(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    public int size(){
        return queSize;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int[] toArray(){
        int[] arr = new int[queSize];

        var cp = front;

        for (int i = 0; i < queSize; i++) {
            arr[i] = cp.val;
            if (cp!=null){
                cp = cp.next;
            }
        }
        return arr;
    }
}

public class linkedlist_queue {

    public static void main(String[] args) {
        /* 初始化队列 */
        LinkedListQueue queue = new LinkedListQueue();

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
    }
}
