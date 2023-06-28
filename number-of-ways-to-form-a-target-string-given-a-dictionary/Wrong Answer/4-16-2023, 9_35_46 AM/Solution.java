// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary

class Solution {
    public int numWays(String[] words, String target){
        int[][] grid= new int[words[0].length()][26];
         int mod = 1000000007;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                grid[j][words[i].charAt(j)-'a']+=1;
            }
        }
        int[] dp= new int[target.length()+1];
        dp[0]=1;
        for(int i=0;i<words[0].length();i++){
            for(int j=target.length()-1;j>=0;j--){
                dp[j+1]+=(dp[j]*grid[i][target.charAt(j)-'a'])%mod;
                dp[j+1]=dp[j+1]%mod;

            }
        }
        return dp[target.length()];
    }
}