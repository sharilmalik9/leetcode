// https://leetcode.com/problems/target-sum

class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int[][] dp= new int[nums.length+1][2*sum+1];
       for(int[] i : dp){
           Arrays.fill(i,-1);
       }
        rec(nums,target,0,0,dp,sum);
        return ans;
        
    }
    public int rec(int[] nums,int target,int i,int curr,int[][] dp,int sum){
        if(curr==target && i==nums.length){
            ans++;
            return 1;
        }
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][curr+sum]!=-1){
            return dp[i][curr+sum];
        }
        int add= rec(nums,target,i+1,curr+nums[i],dp,sum);
        int  sub=rec(nums,target,i+1,curr-nums[i],dp,sum);
        return add+sub;
        

    }
}