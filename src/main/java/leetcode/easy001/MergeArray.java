package leetcode.easy001;

public class MergeArray {
    public static void main(String[] args) {
        int[] nums1 =  new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 =  new int[]{2, 5, 6};
        int m=3,n=3;

        Solution solution = new Solution();
        solution.merge(nums1, m , nums2 , n);
    }

}



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        int[] nums3 = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i<m && j<n) {
            if (i < m && nums1[i] <= nums2[j]) {
                nums3[k++] = nums1[i++];
            } else if (j < n && nums1[i] > nums2[j]) {
                nums3[k++] = nums2[j++];
            }
        }

        while (i < m) {
            nums3[k++] = nums1[i++];
        }

        while (j < n) {
            nums3[k++] = nums2[j++];
        }

        for (int x = 0; x < m + n; x++) {
            nums1[x] = nums3[x];
        }

        System.out.println("k ---> "+ k);
    }
}
