// https://leetcode.com/problems/number-of-digit-one

class Solution {
    String s;
    Integer[][][] dp;
    public int countDigitOne(int n) {
        s=Integer.toString(n);
        dp=new Integer[s.length()+1][s.length()+1][2];
        return rec(0,0,true); 
    }
    public int rec(int idx,int cnt,boolean bounded){
        if(idx==s.length()){
            return cnt;
        }
        if(dp[idx][cnt][bounded?1:0]!=null){
            return dp[idx][cnt][bounded?1:0];
        }
        int digit=9;
        if(bounded){
            digit=s.charAt(idx)-'0';
        }
        int ans=0;
        for(int i=0;i<=digit;i++){
            int hehe=cnt;
            if(i==1){
                hehe+=1;
                
            }
            ans+=rec(idx+1,hehe,bounded && s.charAt(idx)-'0'==i);
        }
        return dp[idx][cnt][bounded?1:0]=ans;
    }
}