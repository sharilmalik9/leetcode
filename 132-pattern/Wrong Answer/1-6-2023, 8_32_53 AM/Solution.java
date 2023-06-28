// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums) {
        for(int i=1;i<nums.length-1;i++){
            int prev=nums[i-1];
            int curr=nums[i];
            int next=nums[i+1];
            if(prev< next && next< curr){
                return true;
            }
        }
        return false;
    }
}