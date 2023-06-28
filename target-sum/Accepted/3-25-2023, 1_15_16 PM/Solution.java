// https://leetcode.com/problems/target-sum

class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int[][] dp= new int[nums.length+1][2*sum+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        rec(nums,target,0,0,dp,sum);
        return ans;
        
    }
    public void rec(int[] nums,int target,int i,int curr,int[][] dp,int sum){
        if(curr==target && i==nums.length){
            ans++;
            return;
        }
        if(i>=nums.length){
            return;
        }
        if(dp[i][curr+sum]!=-1){
            return;
        }
        rec(nums,target,i+1,curr+nums[i],dp,sum);
        rec(nums,target,i+1,curr-nums[i],dp,sum);

    }
}