// https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        rec(board,0,0);
    }
    public boolean rec(char[][] board,int row,int col){
        if(row == 9) {
           return true;
       }
      
       int nrow = 0;
       int ncol = 0;
      
       if(col == 8) {
           nrow = row + 1;
           ncol = 0;
       } else {
           nrow = row;
           ncol = col + 1;
       }
      
       if(board[row][col] != '.') {
           if(rec(board, nrow, ncol)) {
               return true;
           }
       } else {
           //fill the place
           for(int i=1; i<=9; i++) {
               if(check(board, row, col, i)) {
                   board[row][col] = (char)(i+'0');
                   if(rec(board, nrow, ncol))
                       return true;
                   else
                        board[row][col] = '.';
               }
           }
       }
                     
       return false;

    }
    public boolean check(char[][] board,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(board[i][col]-'0'==num){
                return false;
            }
            if(board[row][i]-'0'==num){
                return false;
            }
        }
        int hy=(col/3)*3;
        int hi=(row/3)*3;
        for(int i=hi;i<hi+3;i++){
            for(int j=hy;j<hy+3;j++){
                if(board[i][j]-'0'==num){
                    return false;
                }
            }
        }
        return true;
    }
}