// https://leetcode.com/problems/running-sum-of-1d-array

class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans=new int[nums.length];
            int idx=1;
            ans[0]=nums[0];
            int sum=nums[0];
            for(int i=1;i<nums.length;i++){
                sum+=nums[i];
                ans[idx]=sum;
                idx++;


            }
            return ans;
        
        
    }
}