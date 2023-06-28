// https://leetcode.com/problems/student-attendance-record-ii

class Solution {
    int[][][] dp;
    int mod=1000000007;
    public int checkRecord(int n){
         dp=new int[n+1][2][3];
         for(int[][] i:dp){
             for(int[] j:i){
                     Arrays.fill(j,-1);
             }  
         }
        return rec(n,0,0,0);
    }
    public int rec(int n,int i,int late,int cont){
        if(i==n){
            return 1;
        }
        if(dp[i][late][cont]!=-1){
            return dp[i][late][cont];
        }
        
 

        int ans=0;
        if(late<1){
               ans=(ans+rec(n,i+1,late+1,0))%mod;
        }
        if((i==0 || i==1) || cont<2){
            ans=(ans+rec(n,i+1,late,cont+1))%mod;
        }
        ans=(ans+rec(n,i+1,late,0))%mod;
         return dp[i][late][cont]=ans%mod; 
    }
}