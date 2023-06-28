// https://leetcode.com/problems/solving-questions-with-brainpower

class Solution {
    public long mostPoints(int[][] questions){
        int n=questions.length;
        long[] dp= new long[n+1];
      //  dp[n]=questions[n-1][0];
        for(int i=n-1;i>=0;i--){
           long include=questions[i][0];
           if(i+questions[i][1]<n){
               include+=dp[i+questions[i][1]+1];
           }
           long dont=dp[i+1];
           dp[i]=Math.max(dont,include);
           
        }
        return dp[0];
        

        
    }
}