// https://leetcode.com/problems/word-search-ii

class Solution {
    HashSet<String> hs= new HashSet<>();
    List<String> ls= new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] vis=new boolean[board.length][board[0].length];
        int max=0;
        for(String i: words){
            hs.add(i);
            max=Math.max(max,i.length());
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,max,0,vis);
            }
        }
        return ls;
    }
    public void dfs(char[][] board,int i,int j,int max,int len,boolean[][] vis){
        if(i<0 || j<0|| i>=board.length|| j>=board[0].length){
            return;
        }
        if(vis[i][j] || len>=max){
            return;
        }
        sb.append(board[i][j]);
        vis[i][j]=true;
        if(hs.contains(sb.toString())){
            ls.add(sb.toString()); 
        }
        dfs(board,i-1,j,max,len+1,vis);
        dfs(board,i+1,j,max,len+1,vis);
        dfs(board,i,j-1,max,len+1,vis);
        dfs(board,i,j+1,max,len+1,vis);
        vis[i][j]=false;
        sb.deleteCharAt(sb.length()-1);
        
    }
}