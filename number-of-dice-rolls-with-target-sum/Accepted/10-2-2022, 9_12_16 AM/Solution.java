// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp= new int[n+1][target+1]; 
        int mod = (int) 1e9 + 7;
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                for(int m=1;m<=k;m++){
                    if(j-m>=0){
                        dp[i][j]=(dp[i][j]+dp[i-1][j-m])%mod;
                    }
                }
            }
        }
       return dp[n][target]; 
    }
}