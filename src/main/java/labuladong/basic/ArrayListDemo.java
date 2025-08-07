package labuladong.basic;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Collections.nCopies(10, 0));

        for (var l : nums){
            System.out.print(l+" ");
        }

        System.out.println(nums.isEmpty());

        System.out.println(nums.size());

        nums.add(20);

        System.out.println(nums.size());

        System.out.println(nums.size() -1);

        nums.remove(nums.size() -1 );

        System.out.println(nums.size());

        nums.set(0,11);

        System.out.println(nums.get(0));

        nums.add(3,99);

        System.out.println(nums.get(3));

        System.out.println(nums.size());

        nums.remove(2);
        System.out.println("after remove size ->"+nums.size());


        Collections.swap(nums, 0 ,1);

        for (var n : nums){
            System.out.print(n+" ");
        }
    }
}
