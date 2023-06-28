// https://leetcode.com/problems/largest-local-values-in-a-matrix

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n =grid.length;
        int[][] ans= new int[n-2][n-2];
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                  int max =Integer.MIN_VALUE;
                for(int m =i;m<i+3;m++){
                    for(int p=j;p<j+3;p++){
                        if(max<grid[m][p]){
                            max=grid[m][p];
                            
                        }
                        
                    }
                }
                ans[i][j]=max;
                
                
                
               
            }
            
        }
        return ans;
        
        
        
    }
}