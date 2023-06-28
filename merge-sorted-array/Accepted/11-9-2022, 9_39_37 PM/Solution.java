// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int i = m-1, j = n-1, k = 1;

         while(i >= 0 && j >= 0) {
             if(nums1[i] > nums2[j]) {
                 nums1[m+n-k] = nums1[i--];
                 k++;
             } else if(nums1[i] < nums2[j]) {
                 nums1[m+n-k] = nums2[j--];
                 k++;
             } else {
                 while(i >= 0 && j >= 0 && nums1[i] == nums2[j]) {
                     nums1[m+n-k] = nums2[j--];
                     k++;
                     nums1[m+n-k] = nums1[i--];
                     k++;
                 }
             }
         }

         while(j >= 0) {
             nums1[m+n-k] = nums2[j--];
             k++;
         }
    }
}