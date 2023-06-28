// https://leetcode.com/problems/maximum-length-of-repeated-subarray

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        String s="";
        for(int i:nums1){
            s+=String.valueOf(i);
            
        }
        System.out.println(s);
          String t="";
        for(int i:nums2){
            t+=String.valueOf(i);
            
        }
        return longestCommonSubsequence(s,t);
        
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