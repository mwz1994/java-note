package hash_table;

import utils.ListNode;

import java.util.Arrays;
import java.util.List;

public class built_in_hash {
    public static void main(String[] args) {
        int num = 3;
        int hashNum = Integer.hashCode(num);
// 整数 3 的哈希值为 3
        System.out.println("整数"+ num +"哈希值 "+ hashNum);

        boolean bol = true;
        int hashBol = Boolean.hashCode(bol);
// 布尔量 true 的哈希值为 1231
        System.out.println("布尔量"+ bol +"哈希值 "+ hashBol);
        double dec = 3.14159;
        int hashDec = Double.hashCode(dec);
// 小数 3.14159 的哈希值为 -1340954729
        System.out.println("小数"+ dec +"哈希值 "+ hashDec);
        String str = "Hello 算法";
        int hashStr = str.hashCode();
// 字符串“Hello 算法”的哈希值为 -727081396
        System.out.println("字符串"+  str+"哈希值 "+ hashStr);
        Object[] arr = { 12836, "小哈" };
        int hashTup = Arrays.hashCode(arr);

// 数组 [12836, 小哈] 的哈希值为 1151158
        System.out.println("数组"+  arr+"哈希值 "+ hashTup);
        ListNode obj = new ListNode(0);
        int hashObj = obj.hashCode();
// 节点对象 utils.ListNode@7dc5e7b4 的哈希值为 2110121908
        System.out.println("节点对象"+  obj +"哈希值 "+ hashObj +" 数值 "+ obj.val);
        obj.reSet(100);
        System.out.println("节点对象"+  obj +"哈希值 "+ hashObj+" 数值 "+ obj.val);


        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 = new int[]{4,5,6};
        System.out.println("数组 "+ arr1 +"hash 值"+ arr1.hashCode());
        System.out.println("数组 "+ arr2 +"hash 值"+ arr2.hashCode());
        System.out.println("数组 "+ arr3 +"hash 值"+ arr3.hashCode());
        arr2 = new int[]{4,5,6};
        System.out.println("数组 "+ arr2 +"hash 值"+ arr2.hashCode());

        String str2 = "asdf";

        int hashStr2 = str2.hashCode();
// 字符串“Hello 算法”的哈希值为 -727081396
        System.out.println("字符串"+  str2 +"哈希值 "+ hashStr2);
    }
}
