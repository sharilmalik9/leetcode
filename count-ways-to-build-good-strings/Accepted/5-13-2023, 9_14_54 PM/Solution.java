// https://leetcode.com/problems/count-ways-to-build-good-strings

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp= new int[high+1];
        int ans=0;
       int mod = 1000000007;
       dp[zero] +=1;
       dp[one] +=1;
       for(int i=1;i<=high;i++){
           if(i-zero>0){
               dp[i]=(dp[i-zero]%mod+dp[i]%mod)%mod;
           }
           if(i-one>0){
               dp[i]=(dp[i-one]%mod + dp[i]%mod)%mod;
           }
           if(i>=low && i<=high){
               ans=(dp[i]%mod+ans%mod)%mod;
           }
       }
             return ans; 
    }
}
