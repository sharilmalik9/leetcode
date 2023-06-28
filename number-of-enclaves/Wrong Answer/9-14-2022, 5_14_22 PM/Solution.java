// https://leetcode.com/problems/number-of-enclaves

class Solution {
    int cnt=0;
    public int numEnclaves(int[][] grid) {
        int m =grid.length;
        int n=grid[0].length;
        int cnt1=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    cnt1++;
                }
            }
        }
        
        boolean[][]  vis= new boolean[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                dfs(grid,m,n,vis,i,0);
                
            }
            if(grid[i][n-1]==1){
                dfs(grid,m,n,vis,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                dfs(grid,m,n,vis,0,i);
                
            }
            if(grid[m-1][i]==1){
                dfs(grid,m,n,vis,m-1,i);
            }
        }
        
        
        
        
        return cnt1-cnt>=0 ? cnt1-cnt : 0;
        
        
    }
    public void dfs(int[][] grid,int m,int n,boolean[][] vis,int i,int j ){
        System.out.println(i);
        System.out.println(j);
        vis[i][j]=true;
        cnt++;
        if(i>0 && !vis[i-1][j] && grid[i-1][j]==1){
            dfs(grid,m,n,vis,i-1,j);
            
        }
        if(i<m-1 && !vis[i+1][j] && grid[i+1][j]==1){
            dfs(grid,m,n,vis,i+1,j);
            
        }
        if(j>0 && !vis[i][j-1] && grid[i][j-1]==1){
            dfs(grid,m,n,vis,i,j-1);
            
        }
         if(j<n-1 && !vis[i][j+1] && grid[i][j+1]==1){
            dfs(grid,m,n,vis,i,j+1);
            
        }
        
    }
}