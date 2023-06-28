// https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
         StringBuilder input1 = new StringBuilder();
 
        
        input1.append(s);
        input1.reverse();
        return longest(s,input1.toString());
        
    }
    public int longest(String s1,String s2){
        int[][] dp= new int[s1.length()+1][s2.length()+1];
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}