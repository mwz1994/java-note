package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x){
        val = x;
    }

    public static ListNode arrToLinkedList(int[] arr) {
        ListNode dump = new ListNode(arr[0]);
        var head = dump;
        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dump.next;
    }
}
