// https://leetcode.com/problems/valid-sudoku

class Solution {
    private boolean checkRows(char[][] board){
        for(int r=0; r < board.length; r++){
            int[] count = new int[9];
            for(int c=0; c<board[0].length; c++){
                if(board[r][c] == '.')
                    continue;
                else if(count[Character.getNumericValue(board[r][c]) - 1] != 0)
                    return false;
                else 
                    count[Character.getNumericValue(board[r][c]) - 1] = 1;
            }
        }
        return true;
    }
    
    
    private boolean checkColumns(char[][] board){
        for(int c=0; c < board.length; c++){
            int[] count = new int[9];
            for(int r=0; r<board[0].length; r++){
                if(board[r][c] == '.')
                    continue;
                else if(count[Character.getNumericValue(board[r][c]) - 1] != 0)
                    return false;
                else 
                    count[Character.getNumericValue(board[r][c]) - 1] = 1;
            }
        }
        return true;
    }
    private boolean checki(char[][] board){
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(hs.contains(board[i][j]-'0')){
                    return false;

                }
                hs.add(board[i][j]-'0');
            }
        }

    }
    
    private boolean checkBoxes(char[][] board){
        int[][] count = new int[9][9];
        
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board.length; c++){
                if(board[r][c] == '.')
                    continue;
                else if(count[(r/3)*3 + (c/3)][Character.getNumericValue(board[r][c]) - 1] != 0)
                    return false;
                else
                    count[(r/3)*3 + (c/3)][Character.getNumericValue(board[r][c]) - 1] = 1;
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        return checkRows(board) && checkColumns(board) && checki(board) ;
    }
}