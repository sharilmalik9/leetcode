// https://leetcode.com/problems/non-negative-integers-without-consecutive-ones

class Solution {
    String s;
    Integer[][][] dp;
    public int findIntegers(int n) {
        
        s=Integer.toBinaryString(n);
        dp=new Integer[s.length()+1][2+1][2];
        return rec(0,-1,true);
    }
    public int rec(int idx,int prev,boolean bounded){
        if(idx>=s.length()){
            return 1;
        }
        if(dp[idx][prev+1][bounded?1:0]!=null){
            return dp[idx][prev+1][bounded?1:0];
        }
        int ans=0;
        ans+=rec(idx+1,0,bounded && s.charAt(idx)=='0');
        if(bounded){
            if(s.charAt(idx)=='1' && prev!=1 ){
                  ans+=rec(idx+1,1,bounded && s.charAt(idx)=='1');
            }
        }
        else{
            if(prev!=1){
                ans+=rec(idx+1,1,bounded);
            }


        }
        return dp[idx][prev+1][bounded?1:0]=ans;

    }
}