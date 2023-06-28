// https://leetcode.com/problems/wiggle-sort-ii

class Solution {
  public void wiggleSort(int[] nums) {
        int n = nums.length - 1;
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        // copy 2nd half of sorted array (reverse order) into original nums array at odd position
        for (int i = 1; i < nums.length; i+=2){
            nums[i] = sortedNums[n];
            n--;
        }

        // copy 1st half of sorted array (reverse order) into original nums array at even position
        for (int i = 0; i < nums.length; i+=2){
            nums[i] = sortedNums[n];
            n--;
        }
    }
}