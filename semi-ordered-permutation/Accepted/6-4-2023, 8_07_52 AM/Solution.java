// https://leetcode.com/problems/semi-ordered-permutation

class Solution {
    public int semiOrderedPermutation(int[] nums){
        int min=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                min=i;
            }
            if(nums[i]==nums.length){
                max=i;
            }
        }
        if(min>max){
            return nums.length-1-max-1+min-0;
        }
        return nums.length -1-max+min-0;
    }
}