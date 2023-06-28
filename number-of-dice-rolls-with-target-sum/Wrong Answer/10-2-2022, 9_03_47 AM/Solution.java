// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp= new int[n+1][target+1];
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                int ways=0;
                for(int faces=0;faces<k+1;faces++){
                    if(target-faces>=0){
                        ways+=dp[i-1][target-faces];
                    }
                }
                
                
                dp[i][j]=ways;
                
            }
        }
        return dp[n][target];
    }
}