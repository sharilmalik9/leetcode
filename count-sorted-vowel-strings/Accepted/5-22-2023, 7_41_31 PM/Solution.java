// https://leetcode.com/problems/count-sorted-vowel-strings

class Solution {
    public int countVowelStrings(int n) {
        List<Character> ls=new ArrayList<>();
        ls.add('a');
        ls.add('e');
        ls.add('i');
        ls.add('o');
        ls.add('u');
        int[][] dp= new int[n+1][ls.size()+1];
       for(int[] hey:dp){
           Arrays.fill(hey,-1);
       }
        return rec(n,0,ls,dp);
    }
    public int rec(int n,int idx,List<Character> ls,int[][] dp){
        if(n==0){
            return 1;
        }
        if(idx==ls.size() && n>0){
            return 0;
        }
        int ans=0;
        if(dp[n][idx]!=-1){
            return dp[n][idx];

        }
       
            ans+=rec(n-1,idx,ls,dp);
            ans+=rec(n,idx+1,ls,dp);

        
        return dp[n][idx]=ans;
    }
}