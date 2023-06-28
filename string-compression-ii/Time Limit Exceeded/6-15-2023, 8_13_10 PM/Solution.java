// https://leetcode.com/problems/string-compression-ii

class Solution {
    Integer[][][][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        dp=new Integer[s.length()+1][s.length()+1][27][k+1];
       return rec(0,0,26,k,s);        
    }
    public int rec(int idx,int len,int prev,int k,String s){
        if(k<0){
            return Integer.MAX_VALUE;
        }
        if(idx>=s.length()){
          return 0;
        }
        if(dp[idx][len][prev][k]!=null){
            return dp[idx][len][prev][k];
        }
        // delete
        int ans=rec(idx+1,len,prev,k-1,s);
        //keep
        int cnt=0;
        if(s.charAt(idx)-'a'==prev){
            if(len==1|| len==9||len==99){
                cnt++;    
            }
            ans=Math.min(ans,cnt+rec(idx+1,len+1,prev,k,s));
        }
        else{
            ans=Math.min(ans,1+rec(idx+1,1,s.charAt(idx)-'a',k,s));
        }
        return dp[idx][len][prev][k]=ans;    
    }

}