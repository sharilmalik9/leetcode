// https://leetcode.com/problems/check-if-move-is-legal

class Solution {
    public boolean checkMove(char[][] board, int r, int c, char color) {
      return 
         dfs(board, r, c, color, 1, 1,1)    
      || dfs(board, r, c, color, 1, -1, 1)
      || dfs(board, r, c, color, 1, 0, 1)
      || dfs(board, r, c, color, 0, -1, 1)
      || dfs(board, r, c, color, 0, 1, 1)
      || dfs(board, r, c, color, -1, -1, 1)
      || dfs(board, r, c, color, -1, 0, 1)
      || dfs(board, r, c, color, -1, 1, 1);
        
    }
     private boolean dfs(char[][] board, int r, int c, char color, int r2, int c2, int count) {
       r += r2;
       c += c2;

       if (r < 0 || c < 0 || r > 7 || c > 7 || board[r][c] == '.') return false;
       if (board[r][c] == color ) return count >= 2;
       return dfs(board, r, c, color, r2, c2, ++count);
     }
}