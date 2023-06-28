// https://leetcode.com/problems/ones-and-zeroes

class Solution {
    HashMap<Integer,Integer> one= new HashMap<>();
    HashMap<Integer,Integer> zero=new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {
        for(int i=0;i<strs.length;i++){
            int cntone=0;
            int cntzero=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='1'){
                    cntone++;
                }
                else{
                    cntzero++;
                }
            }
            one.put(i,cntone);
            zero.put(i,cntzero);  
        }
        int[][][] dp= new int[strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<m+1;j++){
                for(int k=0;k<n+1;k++){
                    dp[i][j][k]=-1;
                }
            }

        }
        return help(strs,0,m,n,dp);
    }
    public int help(String[] strs,int idx,int m,int n,int[][][] dp){
        if(idx==strs.length){
            return 0;
        }
        if(m==0 && n==0){
            return 0;
        }
        if(dp[idx][m][n]!=-1){
            return dp[idx][m][n];
        }
        int ones=one.get(idx);
        int zeros=zero.get(idx);
        int include=0;
        if(m-zeros>=0 && n-ones>=0){
            include=1+help(strs,idx+1,m-zeros,n-ones,dp);
        }
        int dont=help(strs,idx+1,m,n,dp);
        return dp[idx][m][n]=Math.max(include,dont);
    }
}