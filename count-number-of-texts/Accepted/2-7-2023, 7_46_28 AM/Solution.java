// https://leetcode.com/problems/count-number-of-texts

class Solution {
    public int countTexts(String s){
        int mod=1000000007;
        int[] dp= new int[s.length()+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            dp[i]=dp[i-1];
            char ch=s.charAt(i-1);
            if(i>=2 && s.charAt(i-2)==ch){
                dp[i]=(dp[i]+dp[i-2])%mod;
            }
            else{
                continue;
            }
            if(i>=3 && s.charAt(i-3)==ch){
                dp[i]=(dp[i]+dp[i-3])%mod;
            }
            else{
                continue;
            }
             if( (ch=='7'|| ch=='9') && i-4>=0  && s.charAt(i-4)==ch){
                dp[i]=(dp[i]+dp[i-4])%mod;
            }
        }

        



       return dp[s.length()]%mod;
        
    }
}