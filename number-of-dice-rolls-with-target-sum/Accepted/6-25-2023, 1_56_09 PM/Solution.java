// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {
    int m=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        if(n==1)
        {
            if(k>=target)
            return 1;
            else
            return 0;
        }
        int t[][]=new int[n+1][target+1];
        for(int[] i:t)
        Arrays.fill(i,-1);

        return solve(n,k,target,t);
    }
    int solve(int n, int k,int t,int[][] dp){
    if(n==0 && t!=0)
     return 0;
     if(n==0 && t==0)
     return 1;
     if(dp[n][t]!=-1)
     return dp[n][t]%m;
     int sum=0;
     for(int i=1;i<=k;i++)
     {
         if(i<=t)
         {sum+=solve(n-1,k,t-i,dp);
            sum=sum%m;
         }
         else
         continue;
     } 
     return dp[n][t]=sum%m;
    }
}