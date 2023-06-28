// https://leetcode.com/problems/unique-paths-iii

class Solution {
   int count = 0;
  int[][] grid;
  int rows, cols;

  public int uniquePathsIII(int[][] grid) {
    rows = grid.length;
    cols = grid[0].length;
    this.grid = grid;
    count = 0;

    int toVisit = 0;
    int startR = 0, startC = 0;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == -1) continue;

        if (grid[r][c] == 1) {
          startC = c;
          startR = r;
        }
        toVisit++;
      }
    }

    dfs(startR, startC, toVisit);

    return count;
  }

  void dfs(int r, int c, int toVisit) {
    toVisit--;
    if (toVisit < 0)
      return;
    if (grid[r][c] == 2 && toVisit == 0) {
      count++;
      return;
    }
    if (grid[r][c] == -1)
      return;

    grid[r][c] = 3;

    if (r > 0 && grid[r - 1][c] != 3) {
      int state = grid[r - 1][c];
      dfs(r - 1, c, toVisit);
      grid[r - 1][c] = state;
    }
    if (c > 0 && grid[r][c - 1] != 3) {
      int state = grid[r][c - 1];
      dfs(r, c - 1, toVisit);
      grid[r][c - 1] = state;
    }
    if (r < rows - 1 && grid[r + 1][c] != 3) {
      int state = grid[r + 1][c];
      dfs(r + 1, c, toVisit);
      grid[r + 1][c] = state;
    }
    if (c < cols - 1 && grid[r][c + 1] != 3) {
      int state = grid[r][c + 1];
      dfs(r, c + 1, toVisit);
      grid[r][c + 1] = state;
    }
  }
}