// https://leetcode.com/problems/path-with-maximum-gold

class Solution {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] visited = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] != 0) {
                    getMaximumGold(grid, i, j, 0, visited);
                }
            }
        }
        return max;
    }

    private void getMaximumGold(int[][] grid, int row, int col, int sum, int[][]visited) {
        if(row < 0 || row >= grid.length || col >= grid[0].length || col < 0 || grid[row][col] == 0 || visited[row][col] == 1){
            max = Math.max(max, sum);
            return;
        }

        visited[row][col] = 1;
        getMaximumGold(grid, row+1, col, sum + grid[row][col], visited);
        getMaximumGold(grid, row-1, col, sum + grid[row][col], visited);
        getMaximumGold(grid, row, col+1, sum + grid[row][col], visited);
        getMaximumGold(grid, row, col-1, sum + grid[row][col], visited);
        visited[row][col] = 0;
        
    }
}