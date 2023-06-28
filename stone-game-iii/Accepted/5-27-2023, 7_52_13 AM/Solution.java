// https://leetcode.com/problems/stone-game-iii

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp= new int[stoneValue.length+1];
        for(int i=n-1;i>=0;i--){
            int ans=Integer.MIN_VALUE;
            int sum=0;
            for(int j=0;j<3 && i+j<n;j++){
                sum+=stoneValue[i+j];
                ans=Math.max(ans,sum-dp[i+j+1]);
            }
            dp[i]=ans;
        }
        if(dp[0]>0){
            return "Alice";
        }
        if(dp[0]<0){
            return "Bob";
        }
        else{
            return "Tie";
        }
    }
}