// https://leetcode.com/problems/maximum-product-of-three-numbers

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
       int i = nums[n-1]*nums[n-2]*nums[n-3];
    int j = nums[0]*nums[1]*nums[n-1];
    
    return (i>j)?i:j;
    }
}