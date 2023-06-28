// https://leetcode.com/problems/minimum-falling-path-sum

class Solution {
    public int minFallingPathSum(int[][] m) {
        int k=m.length;
        int n=Integer.MAX_VALUE;
        int dp[] = new int[k];
        for(int i=0;i<k;i++)
        {
            dp[i]=m[0][i];
        }
        for(int i=1;i<k;i++)
        {
            int a[] = new int[k];
            for(int j=0;j<k;j++)
            {
                if(j==0)
                {
                    a[j]=m[i][j]+Math.min(dp[j],dp[j+1]);
                }
                else if(j==k-1)
                {
                    a[j]=m[i][j]+Math.min(dp[j],dp[j-1]);
                }
                else
                {
                    a[j]=m[i][j]+Math.min(dp[j],Math.min(dp[j+1],dp[j-1]));
                }
            }
            dp=a;
        }
        int f=Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
        {
            f=Math.min(f,dp[i]);
        }
        return f;
    }
}