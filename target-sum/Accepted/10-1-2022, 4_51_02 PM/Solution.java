// https://leetcode.com/problems/target-sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
             sum+=nums[i];
        if(target>sum || target < -sum || (target+sum)%2 ==1)
            return 0;
        sum=(sum+target)/2;
        int[][] dp=new int[nums.length+1][sum+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
                if(i-1>=0)
                {
                    if(nums[i-1]>j) // ith item's magnitude is greater than weight(i.e,j) then skip it
                        dp[i][j]=dp[i-1][j];
                    else
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}