package labuladong.basic;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> lst = new LinkedList<>(Arrays.asList(1,2,3,4,5));

        System.out.println(lst.isEmpty());

        System.out.println(lst.size());

        lst.addFirst(0);
        lst.addLast(6);

        System.out.println(lst.getFirst() + "  "+lst.getLast());

        lst.removeFirst();

        lst.removeLast();

        lst.add(2, 99);

        lst.remove(1);

        for (var val: lst){
            System.out.print(val + " ");
        }

    }

}
