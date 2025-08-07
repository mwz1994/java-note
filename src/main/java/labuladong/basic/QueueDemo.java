package labuladong.basic;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println(q.isEmpty());

        System.out.println(q.size());

        System.out.println(q.peek());

        q.poll();

        System.out.println();
    }
}
