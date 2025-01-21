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
        /* 初始化栈 */
        LinkedListStack stack = new LinkedListStack();

        /* 元素入栈 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        System.out.println("栈 stack = " + Arrays.toString(stack.toArray()));

        /* 访问栈顶元素 */
        int peek = stack.peek();
        System.out.println("栈顶元素 peek = " + peek);

        /* 元素出栈 */
        int pop = stack.pop();
        System.out.println("出栈元素 pop = " + pop + "，出栈后 stack = " + Arrays.toString(stack.toArray()));

        /* 获取栈的长度 */
        int size = stack.size();
        System.out.println("栈的长度 size = " + size);

        /* 判断是否为空 */
        boolean isEmpty = stack.isEmpty();
        System.out.println("栈是否为空 = " + isEmpty);
    }
}
