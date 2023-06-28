// https://leetcode.com/problems/regular-expression-matching

class Solution {
     public boolean isMatch(String s, String p) {
        int m =s.length();
        int n =p.length();
        boolean[][] dp= new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            boolean flag=true;
                if(p.charAt(i-1)=='*' && dp[0][i-2]){
                  dp[i][0]=true;
            } 
            
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
}
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(s.charAt(i-1)==p.charAt(j-2)|| p.charAt(j-2)=='.'){
                        dp[i][j]=dp[i][j] || dp[i-1][j];
                    }
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[m][n];
        
    }
}