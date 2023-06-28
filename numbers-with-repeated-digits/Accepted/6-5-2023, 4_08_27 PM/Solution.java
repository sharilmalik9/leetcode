// https://leetcode.com/problems/numbers-with-repeated-digits

class Solution {
    String s;
    boolean[] vis;
    Integer[][][] dp;
    public int numDupDigitsAtMostN(int n) {
        s=Integer.toString(n);
        vis=new boolean[10];
        dp=new Integer[2][s.length()+1][2];
        return n-rec(true,0,false)+1;
    }
    public int rec(boolean bounded,int idx,boolean hehe){
        if(idx>=s.length()){
            return 1;
        }
        int ans=0;
        int he=9;
        // if(dp[][][]!=null && vis[idx]){
            
        // }
        if(bounded){
            he=s.charAt(idx)-'0';
        }
        for(int i=0;i<=he;i++){
            if(i==0 && !hehe){
                ans+=rec(bounded && s.charAt(i)-'0'==i,idx+1,hehe);
            }
            else if(!vis[i]){ 
            vis[i]=true;
            ans+=rec(bounded && i==s.charAt(idx)-'0',idx+1,true);
            vis[i]=false;
            }
            
        }
        return ans;
    }
}