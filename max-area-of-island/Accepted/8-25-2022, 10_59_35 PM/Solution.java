// https://leetcode.com/problems/max-area-of-island

class Solution {
   public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    int island = dfs(grid, i, j);
                    max = Math.max(max, island);
                }
            }
        }
        
        return max;
    }
    
    int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    public int dfs(int[][] grid, int i, int j){
        
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0){
            return 0;
        }
        
        int count = 1;
        grid[i][j] = 0;
        for(int k = 0 ; k < dir.length ; k++){
            count += dfs(grid, i+dir[k][0], j+dir[k][1]);
        }
        
        return count;
    }
}