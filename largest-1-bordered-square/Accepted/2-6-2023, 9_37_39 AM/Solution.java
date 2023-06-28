// https://leetcode.com/problems/largest-1-bordered-square

class Solution {
    public int largest1BorderedSquare(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] up=new int[m][n];
        int[][] side=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    side[i][j]=(i==0) ? 1: side[i-1][j]+1;
                    up[i][j]=(j==0) ? 1: up[i][j-1]+1;

                }
            }
        }
        int max=0;
     
       
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int min=Math.min(up[i][j],side[i][j]);
                while(min>max){
                    if(up[i-min+1][j]>=min && side[i][j-min+1]>=min){
                        max=min;
                    }
                    min--;
                }
            }
        }
        return max*max;
    }
}