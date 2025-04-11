package utils;

import java.util.ArrayList;
import java.util.List;

class Trunk{
    Trunk prev;
    String str;

    Trunk(Trunk trunk , String str){
        this.prev = trunk;
        this.str = str;
    }
}

public class PrintUtil {
    /* 打印矩阵（Array） */
    public static <T> void printMatrix(T[][] matrix){
        System.out.println("[");
        for (T[] row : matrix){
            System.out.println("  "+row+ ",");
        }
        System.out.println("]");
    }

    /* 打印矩阵（List） */
    public static <T> void printMatrix(List<List<T>> matrix) {
        System.out.println("[");
        for (List<T> row : matrix) {
            System.out.println("  " + row + ",");
        }
        System.out.println("]");
    }

    /* 打印链表 */
    public static void printLinkedList(ListNode head){
        List<String> list = new ArrayList<>();
        while (head != null){
            list.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(String.join(" -> ", list));
    }

}
