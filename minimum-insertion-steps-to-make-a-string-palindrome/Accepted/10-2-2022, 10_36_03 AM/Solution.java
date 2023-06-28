// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome

class Solution {
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
        
    }
     public int longestPalindromeSubseq(String s) {
        StringBuilder input1 = new StringBuilder();
 
        
        input1.append(s);
        input1.reverse();
        return longestCommonSubsequence(s,input1.toString());
        
    }
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