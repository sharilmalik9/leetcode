// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner

class Solution {
    class pair{
        int x;
        int y;
        public pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumObstacles(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp= new int[grid.length][grid[0].length];
        for(int[] curr: dp){
            Arrays.fill(curr,Integer.MAX_VALUE);

        }
        
        dp[0][0]=0;
        Queue<pair> que= new LinkedList<>();
        que.add(new pair(0,0));
        while(que.size()!=0){
            int size=que.size();
            while(size!=0){
                pair curr=que.poll();
                for(int i=0;i<4;i++){
                    int x=curr.x+dir[i][0];
                    int y=curr.y+dir[i][1];
                    if(x<m && x>=0 && y<n && y>=0 && dp[x][y]> (grid[x][y] + dp[curr.x][curr.y])){
                        dp[x][y] = grid[x][y] +dp[curr.x][curr.y];
                        que.add(new pair(x,y));
                    }
                }
                size--;

                
                        
                        
                        
                        
                        
                        
                 }
        }
        return dp[m-1][n-1];

        
    }
}