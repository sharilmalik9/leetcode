// https://leetcode.com/problems/restore-the-array

class Solution {
    int mod=1000000007;
    public int numberOfArrays(String s, int k) {
        int[] dp= new int[s.length()+1];
        Arrays.fill(dp,-1);
        return rec(s,0,0,k,dp);
    }
    public int rec(String s,int no,int idx,int k,int[] dp){
        if(idx==s.length()){
           
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        long ans=0;
          
        if(s.charAt(idx)=='0'){
            if(no!=0 && no*10<=k){
                ans=rec(s,no*10,idx+1,k,dp);
                 return (int)ans%mod;
            }
            else{
           
                return 0;
            }
            
        }
        else if(no*10+(s.charAt(idx)-'0')<=k){
            ans=rec(s,no*10+(s.charAt(idx)-'0'),idx+1,k,dp);
        }
        if(no!=0){
             ans+=rec(s,s.charAt(idx)-'0',idx+1,k,dp);
        }
      
        ans%=mod;
        return dp[idx]=(int)ans;
    }
}