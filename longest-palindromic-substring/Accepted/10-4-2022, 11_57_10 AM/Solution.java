// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int mf=0;
        int jf=0;
        boolean[][] dp= new boolean[s.length()][s.length()];
        for(int gap=0;gap<s.length();gap++){
            
            for(int j=gap,i=0;j<s.length();j++,i++){
                if(gap==0){
                    dp[i][j]=true;
}
                else if(gap==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j]){
                    mf=i;
                    jf=j;
                }
}
        }
        return s.substring(mf,jf+1);
        
        
    }
     
}