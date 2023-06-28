// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors

class Solution 
{
    public int solve(int f,int e,int[][] dp)
    {
        if(f<=2 || e==1) return f;
        if(dp[f][e]!=-1) return dp[f][e];
        
        int min=f;
        
        for(int i=1;i<=f;++i)
        {
            int Break=solve(i-1,e-1,dp);
            int notBreak=solve(f-i,e,dp);
            int worstCase=1+Math.max(Break,notBreak);
            min=Math.min(min,worstCase);
        }
        
        return dp[f][e]=min;
    }
    public int twoEggDrop(int n) 
    {
        int eggs=2;
        int[][] dp=new int[n+1][3];
        /*for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return solve(n,2,dp);
        */
        for(int f=1;f<=n;++f)
        {
            for(int e=1;e<=2;++e)
            {
                if(f<=2 || e==1)
                {
                    dp[f][e]=f;
                    continue;
                }
                int min=(int)Math.pow(10,9);
        
                for(int i=1;i<f;++i)
                {
                    int Break=dp[i-1][e-1];
                    int notBreak=dp[f-i][e];
                    int worstCase=1+Math.max(Break,notBreak);
                    min=Math.min(min,worstCase);
                }
        
                dp[f][e]=min;
            }
        }
        return dp[n][2];
    }
}