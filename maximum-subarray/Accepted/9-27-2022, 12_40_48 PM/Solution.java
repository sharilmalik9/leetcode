// https://leetcode.com/problems/maximum-subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int curval=nums[0];
        int maxval=nums[0];
        for(int i=1;i<nums.length;i++){
            if(curval>0){
                curval=curval+nums[i];
            }
            else{
                curval=nums[i];
            }
            maxval=Math.max(curval,maxval);
        }
        return maxval;
    }
}