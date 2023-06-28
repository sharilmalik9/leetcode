// https://leetcode.com/problems/check-knight-tour-configuration

class Solution {
    int[][] ways={{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
    public boolean checkValidGrid(int[][] grid){
        boolean[][] vis= new boolean[grid.length][grid[0].length];
        
        if(grid[0][0]!=0){
            return false;
        }
        return dfs(grid,0,0,0,vis);
        
    }
    public boolean dfs(int[][] grid,int i,int j,int curr,boolean[][] vis){
        vis[i][j]=true;
        if(curr==(grid.length)*(grid.length)-1){
            return true;
        }
        int x=-1;
        int y=-1;
        for(int m=0;m<8;m++){
            int currx=ways[m][0]+i;
            int curry=ways[m][1]+j;
            if(isvalid(currx,curry,grid.length) && !vis[currx][curry] && grid[currx][curry]==curr+1){
                x=currx;
                y=curry;
            }
        }
        if(x==-1 && y==-1){
            return false;
        }
        else{
            return dfs(grid,x,y,curr+1,vis);
        }

        
    }
    public boolean isvalid(int x ,int y,int n){
        if(x<0 || x>n-1 || y<0 || y>n-1){
            return false;
        }
        return true;
    }
}