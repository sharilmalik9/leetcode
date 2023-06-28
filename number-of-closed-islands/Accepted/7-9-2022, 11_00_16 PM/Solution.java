// https://leetcode.com/problems/number-of-closed-islands

class Solution {

public int closedIsland(int[][] grid) {
    if(grid.length==0) return 0;
    int row = grid.length;
    int col = grid[0].length;
    int closedIsland = 0;    
    
    for(int i=1; i<row-1; i++){
        for(int j=1; j<col-1; j++){
            if(grid[i][j]==0){
                if(isClosedIsland(grid, i, j, row, col))
                    closedIsland++;
            }
        }
    }
    return closedIsland;
}

private boolean isClosedIsland(int[][] grid, int i, int j, int row, int col){
    
    //-1: visited, 1: water, 0: land
    if(grid[i][j]==-1 || grid[i][j]==1) 
        return true;
    if(isOnParamenter(i,j,row,col)) return false;
    grid[i][j] = -1; //Mark -1 if visited once

    boolean up=true, down=true, left=true, right=true;
    up = isClosedIsland(grid, i-1, j, row, col);//up
    left = isClosedIsland(grid, i, j-1, row, col);//left
    down = isClosedIsland(grid, i+1, j, row, col);//down
    right = isClosedIsland(grid, i, j+1, row, col);//right
    
    return up && left && down && right;
}

private boolean isOnParamenter(int i, int j, int row, int col){
    return i==0 || j==0 || i==row-1 || j==col-1;
}
}