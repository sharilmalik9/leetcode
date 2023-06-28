// https://leetcode.com/problems/01-matrix

class Solution {
    class pair{
        int x;
        int y;
        int steps;
        pair(int x,int y,int steps){
            this.x=x;
            this.y=y;
            this.steps=steps;
        }
        
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans=new int[mat.length][mat[0].length];
        boolean[][] vis= new boolean[mat.length][mat[0].length];
        Queue<pair> que= new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                   que.add(new pair(i,j,0));
                    vis[i][j]=true;
                }
                
            }
        }
        while(que.size()>0){
            pair pp= que.poll();
            int i=pp.x;
            int j=pp.y;
            int dis=pp.steps;
            vis[i][j]=true;
            ans[i][j]=dis;
            if(i>0 && !vis[i-1][j]){
                que.add(new pair(i-1,j,dis+1));
            }
            if(j>0  && !vis[i][j-1]){
                que.add(new pair(i,j-1,dis+1));
            }
            if(i<mat.length-1  && !vis[i+1][j]){
                que.add(new pair(i+1,j,dis+1));
            }
            if(j<mat[0].length-1  && !vis[i][j+1]){
                que.add(new pair(i,j+1,dis+1));
            }
            
        }
        return ans;
    }
}