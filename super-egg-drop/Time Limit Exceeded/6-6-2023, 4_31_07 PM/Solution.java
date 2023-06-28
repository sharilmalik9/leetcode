// https://leetcode.com/problems/super-egg-drop

class Solution {
    Integer[][] dp;
    public int superEggDrop(int k, int n) {
        dp=new Integer[k+1][n+1];
        return rec(k,n);
    }
    public int rec(int eggs,int n){
        if(n<=1){
            return n;
        }
        if(eggs==1){
            return n;
        }
        if(dp[eggs][n]!=null){
            return dp[eggs][n];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            ans=Math.min(ans,Math.max(rec(eggs-1,i-1),rec(eggs,n-i)));
        }
        return dp[eggs][n]=ans+1;
    }
}