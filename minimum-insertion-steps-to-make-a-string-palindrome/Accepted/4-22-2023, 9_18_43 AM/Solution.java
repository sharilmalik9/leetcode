// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome

class Solution {
    public int minInsertions(String s) {
        StringBuilder sb= new StringBuilder(s);
        int len=rec(s,sb.reverse().toString());
        return s.length()-len;
        
    }
    public int rec(String s,String t){
        int[][] dp= new int[s.length()+1][t.length()+1];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=t.length()-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }

            }
        }
        return dp[0][0];
    }
}