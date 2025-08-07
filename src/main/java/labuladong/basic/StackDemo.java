package labuladong.basic;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);
        s.addElement(40);

        System.out.println(s.isEmpty());
        System.out.println(s.size());
        System.out.println(s.peek());

        s.pop();

        System.out.println(s.peek());
    }
}
