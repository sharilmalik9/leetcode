// https://leetcode.com/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
        int[] dp= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            int ans=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                if(j*j==i){
                    ans=0;
                }
                ans=Math.min(dp[i-j*j],ans);
}
            dp[i]=ans+1;
        }
        return dp[n];
        
    }
}