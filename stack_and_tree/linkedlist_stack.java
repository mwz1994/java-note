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

    }

    /* 访问栈顶元素 */
    public int peek(){

    };

    /* 将 List 转化为 Array 并返回 */
    public int[] toArray(){

    }

}
