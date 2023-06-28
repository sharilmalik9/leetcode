// https://leetcode.com/problems/edit-distance

class Solution {
    public int minDistance(String s, String t) {
        int m =s.length();
        int n = t.length();
        int[][] dp= new int[m+1][n+1];
        for(int j=n-1;j>=0;j--){
            dp[m][j]=n-j;
        }
        for(int j=m-1;j>=0;j--){
            dp[j][n]=m-j;
        }
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int ans;
                if(s.charAt(i)==t.charAt(j)){
                   ans=dp[i+1][j+1]; 
                }
                else{
                ans= Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]))+1;
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
}