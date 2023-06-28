// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    
    public String longestPalindrome(String s) {
        
        System.out.println(longestPalindromeSubseq(s));
        return longestPalindromeSubseq(s);
    }
     public String longestPalindromeSubseq(String s) {
        StringBuilder input1 = new StringBuilder();
 
        
        input1.append(s);
        input1.reverse();
        return longestCommonSubsequence(s,input1.toString());
        
    }
     public String longestCommonSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i = m-1; i>=0 ; i--){
        	for(int j = n-1; j>=0 ; j--){
                
                int ans=0;
				if(s.charAt(i) == t.charAt(j)){
                    ans=dp[i+1][j+1]+1;
                }
                else{
                    ans=dp[i+1][j+1];
                }
               
                dp[i][j]=ans;
            }
        }
        return print(dp,m,n,s,t);
    }
    public String print(int[][] dp,int n , int m,String s1,String s2 ){
        int len = dp[n][m];
         int i = n;
          int j = m;

  int index = len - 1;
  String ans = "";

  while (i > 0 && j > 0) {
    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      ans += s1.charAt(i-1);
      index--;
      i--;
      j--;
    }
      else{
          i--;
          j--;
      }
   
  }
      return  ans;
    }
}