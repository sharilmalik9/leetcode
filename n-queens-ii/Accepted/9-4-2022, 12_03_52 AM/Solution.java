// https://leetcode.com/problems/n-queens-ii

class Solution {
    int cnt=0;
    public int totalNQueens(int n) {
        String[][] board= new String[n][n];
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                board[i][j] = ".";
            }
        }
        backTrack(n,0,board);
        return cnt;
        
    }
      public void backTrack(int n,int r,String[][] board){
        if(r==n){
            cnt++;
            return;
}
        for(int i=0;i<n;i++){
            if(check(board,r,i,n)){
                board[r][i]="Q";
                backTrack(n,r+1,board);
                board[r][i]=".";
            }
            
}
    }
    public boolean check(String[][] board,int r,int c,int n ){
        for(int i=0;i<r;i++){
            if(board[i][c]=="Q"){
                return false;
            }
        }
        for(int i=r-1 ,j=c-1;i>=0 &&j>=0;i--,j--){
            if(board[i][j]=="Q"){
                return false;
            }
        }
         for(int i=r-1,j=c+1; i>=0 && j<n; i--,j++){
            if(board[i][j] == "Q"){
                return false;
            }
        }
        return true;
}
}