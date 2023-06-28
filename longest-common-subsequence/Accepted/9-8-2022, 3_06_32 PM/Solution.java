// https://leetcode.com/problems/longest-common-subsequence

class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        
        int dp[][] = new int[m+1][n+1];
        
        
        // Arrays.fill(dp, Integer.MAX_VALUE);
       
        
        for(int i = m-1; i>=0 ; i--){
        	for(int j = n-1; j>=0 ; j--){
                
                int ans;
				if(s.charAt(i) == t.charAt(j)){
                    ans=dp[i+1][j+1]+1;
                } 
                else{
                    ans=Math.max(dp[i+1][j],dp[i][j+1]);
                    
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
}