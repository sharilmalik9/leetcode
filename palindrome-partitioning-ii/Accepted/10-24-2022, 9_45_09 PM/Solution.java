// https://leetcode.com/problems/palindrome-partitioning-ii

class Solution {
    int[][] dp = new int[2001][2001];
    public int minCut(String str) {
        int i=0, j=str.length()-1;
        
        for (int[] ks : dp) {
			Arrays.fill(ks, -1);
		}
        return minPalPartion(str,i,j);

    }
    int minPalPartion(String string, int i, int j){   
      if( i >= j || isPalindrome(string, i, j) )
        return 0;
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
         dp[i][j] = Integer.MAX_VALUE;
         for(int k = i; k < j; k++){
             if(isPalindrome(string,i,k)){
              int count = Math.min(dp[i][j], minPalPartion(string, i, k) + minPalPartion(string, k + 1, j) + 1);
              dp[i][j]=count;
             }
         }
    return dp[i][j];
  }
    
    boolean isPalindrome(String string, int i, int j){
      while(i < j){
      if(string.charAt(i) != string.charAt(j))
        return false; 
      i++;
      j--;
    }
    return true;
  }
}