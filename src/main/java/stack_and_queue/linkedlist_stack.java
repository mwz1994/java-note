package stack_and_queue;

import utils.ListNode;

import java.util.Arrays;

class LinkedListStack {
    private ListNode stackPeek;
    private int stkSize = 0;

    public LinkedListStack(){
        stackPeek = null;
    }

    public int size(){
        return stkSize;
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int num){
        ListNode ld = new ListNode(num);
        ld.next = stackPeek;
        stackPeek = ld;
        stkSize++;
    }

    /* 出栈 */
    public int pop(){
        var head = stackPeek;
        stackPeek = stackPeek.next;
        stkSize--;
        return head.val;
    }

    /* 访问栈顶元素 */
    public int peek(){
        return stackPeek.val;
    };

    /* 将 List 转化为 Array 并返回 */
    public int[] toArray(){
        int[] arr = new int[stkSize];
        var head = stackPeek;
        for (int i = 0; i < stkSize; i++) {
            if (head != null){
                arr[i] = head.val;
                head = head.next;
            }
        }
        return arr;
    }

}

public class linkedlist_stack {
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
