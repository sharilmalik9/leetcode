// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid

class Solution {
    public int findMaxFish(int[][] grid){
        boolean[][] vis= new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0 && !vis[i][j]){
                    ans=Math.max(dfs(grid,vis,i,j),ans);
                }
            }
        }
       return ans; 
        
    }
    public int dfs(int[][] grid,boolean[][] vis,int r ,int c ){
        if(r<0 || c<0 || r>=grid.length|| c>=grid[0].length || vis[r][c] || grid[r][c]==0){
            return 0;
        }
        vis[r][c]=true;
        int curr=grid[r][c];
        
        curr+=dfs(grid,vis,r,c+1);
        curr+=dfs(grid,vis,r,c-1);
        curr+=dfs(grid,vis,r+1,c);
        curr+=dfs(grid,vis,r-1,c);
        return curr;
    }
}