// https://leetcode.com/problems/student-attendance-record-ii

class Solution {
    int[][] dp;
    public int checkRecord(int n){
         dp=new int[n+1][2];
         for(int[] i:dp){
             Arrays.fill(i,-1);
         }
        return rec(n,0,0,"");
    }
    public int rec(int n,int i,int late,String str){
        if(i==n){
            System.out.println(str);
            return 1;
        }
        if(dp[i][late]!=-1){
            return dp[i][late];
        }
        int ans=0;
        if(late<1){
               ans+=rec(n,i+1,late+1,str+'A');
        }
        if((i==0 || i==1) || !(str.charAt(str.length()-1)=='L'&& str.charAt(str.length()-2)=='L')){
            ans+=rec(n,i+1,late,str+'L');
        }
        ans+=rec(n,i+1,late,str+'P');
         return dp[i][late]=ans; 
    }
}