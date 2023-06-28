// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges

class Solution {
    public int minDays(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<n+1;i++){
            int ans=Integer.MAX_VALUE;
            ans=Math.min(ans,dp[i-1]+1);
            if(i%2==0 && i-i/2>=0){
                ans=Math.min(ans,dp[i-i/2]+1);
            }
            if(i%3==0 && i-2*(i/3)>=0){
                ans=Math.min(ans,dp[i-2*(i/3)]+1);

            }
            dp[i]=ans;


        }
        return dp[n];
        
    }
}