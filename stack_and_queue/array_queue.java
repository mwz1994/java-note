package stack_and_queue;

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

    }

    int pop(){}

    int peek(){}

    int[] toArray(){}
}

public class array_queue {
    public static void main(String[] args) {
//        Integer[] arr = new Integer[5];
//        arr[0] = 1;
//        arr[1] = 2;
//
//        for (var a : arr){
//            System.out.println("arr --> " + a);
//        }
    }
}
