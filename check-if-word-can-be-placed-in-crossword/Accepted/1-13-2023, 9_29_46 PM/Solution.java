// https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword

class Solution {
    char[][] board;
    String word;
    int rows;
    int cols;
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    //                    down   right   up   left
    public boolean placeWordInCrossword(char[][] board, String word) {
        this.board=board;
        this.word = word;
        rows=board.length;
        cols=board[0].length;
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(board[i][j]==' '||board[i][j]==word.charAt(0)){
                    boolean res=false;
                    if(out(i-1,j)) res|=dfs(i,j,0,0);
                    if(out(i,j-1)) res|=dfs(i,j,0,1);                
                    if(out(i+1,j)) res|=dfs(i,j,0,2);
                    if(out(i,j+1)) res|=dfs(i,j,0,3);
                    if(res) return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, int index,int direction){
        
        if(index==word.length()){
            if(out(i,j)) return true;
            return false;
        }
        
        if(out(i,j)) return false;
        boolean res = false;
        
        if(board[i][j]==' '|| board[i][j]== word.charAt(index)){
            res|=dfs(i+directions[direction][0], j+ directions[direction][1],index+1,direction);
        }
        return res;
        
        
    }
    
    public boolean out(int i,int j){
        return i<0||j<0||i>=rows||j>=cols|| board[i][j]=='#';
    }
}