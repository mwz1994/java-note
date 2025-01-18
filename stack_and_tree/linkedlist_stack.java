package stack_and_tree;

import utils.ListNode;

import java.util.List;

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
        var v = stackPeek.val;
        stackPeek = stackPeek.next;
        stkSize--;
        return v;
    }

    /* 访问栈顶元素 */
    public int peek(){
        return stackPeek.val;
    };

    /* 将 List 转化为 Array 并返回 */
    public int[] toArray(){
        int[] array = new int[stkSize];
        ListNode node= stackPeek;
        int i = 0;
        while (node != null){
            array[i] = node.val;
            node = node.next;
            i++;
        }
        return array;
    }

}
