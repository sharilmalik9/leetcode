// https://leetcode.com/problems/number-of-islands

class Solution {
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n =grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    util(i,j,grid,visited);
                    count++;
                }
                
                
            }
        }
        return count;
        
        
    }
    public void util(int i,int j,char[][] grid,boolean[][] visited){
        visited[i][j] = true;
        int n = grid.length, m = grid[0].length;
                
        //Left..
        if(j-1>=0){
            if(grid[i][j-1]=='1' && !visited[i][j-1]) 
                util(i, j-1, grid, visited);
        }
        
        //Top..
        if(i-1>=0){
            if(grid[i-1][j]=='1' && !visited[i-1][j]) 
                util(i-1, j, grid, visited);
        }
        
        //Right..
        if(j+1<m){
            if(grid[i][j+1]=='1' && !visited[i][j+1]) 
                util(i, j+1, grid, visited);
        }
        
        //Bottom..
        if(i+1<n){
            if(grid[i+1][j]=='1' && !visited[i+1][j]) 
                util(i+1, j, grid, visited);
        }
        
    }
}