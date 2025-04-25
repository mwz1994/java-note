package leetcode.easy002;

import java.util.Arrays;

public class easy002 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        var nums = new int[]{0,1,2,2,3,0,4,2};
        solution.removeElement(nums ,2 );
        System.out.println("nums --> "+ nums.toString());
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {

        int sum = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                sum++;
                nums[j++] = nums[i];
            }
        }
        return sum;
    }
}
