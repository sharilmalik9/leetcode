// https://leetcode.com/problems/combination-sum-iv

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp =new int[target+1];
        Arrays.fill(dp,-1);
        return rec(nums,target,dp);
    }
    public int rec(int[] nums,int target,int[] dp){
        if(target==0){
            return 1;
        }
       
        if(target<0){
            return 0;
        }
        int ans=0;
        if(dp[target]!=-1){
            return dp[target];
        }
        for(int k=0;k<nums.length;k++){
            if(target>=nums[k]){
                   ans+=rec(nums,target-nums[k],dp);
            }
           
        }
        return dp[target]=ans;
    }
}