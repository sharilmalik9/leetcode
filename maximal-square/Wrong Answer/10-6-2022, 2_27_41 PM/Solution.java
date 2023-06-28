// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n = matrix[0].length;
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++){
           dp[i][0]=matrix[i][0]-'0';
        }
        for(int i=0;i<n;i++){
          dp[0][i]=matrix[0][i]-'0';
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]-'0'==0){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               System.out.print(dp[i][j]);
               ans= Math.max(dp[i][j],ans);
            }
             System.out.println();
        }
      //  System.out.println();
        
        return ans*2;
    }
}