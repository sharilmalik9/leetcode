// https://leetcode.com/problems/count-sub-islands

class Solution {
    boolean res;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans=0;
        int m=grid1.length;
        int n=grid1[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1){
                    res=true;
                    dfs(grid1,grid2,i,j,m,n);
                    if(res){
                        ans++;
                    }
                }
            }
        }
        return ans;
        
    }
    public void dfs(int[][] grid1,int[][] grid2,int i,int j,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n || grid2[i][j]==0 ){
            return;
        }
        if(grid1[i][j]==0){
            res=false;
            return;
        }
        grid2[i][j]=0;
        dfs(grid1,grid2,i-1,j,m,n);
        dfs(grid1,grid2,i,j-1,m,n);
        dfs(grid1,grid2,i+1,j,m,n);
        dfs(grid1,grid2,i,j+1,m,n);
    }
}