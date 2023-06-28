// https://leetcode.com/problems/shortest-bridge

class Solution {
    class pair{
        int row;
        int col;
        pair(int x,int y){
            this.row=x;
            this.col=y;
            
        }
    }
    public int shortestBridge(int[][] grid) {
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        LinkedList<pair> que= new LinkedList<>();
        boolean flag=true;
        for(int i=0;i<grid.length;i++){
            for(int j=0;i<grid[0].length;i++){
                 if(grid[i][j]==1 && flag){
                     flag=false;
                     System.out.println(i + " "+ j);
                     dfs(grid,visited,i,j,que);
}  
            }
        }
        int level=0;
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                pair curr= que.removeFirst();
                int x=curr.row;
                int y=curr.col;
                
        if(x>0 && !visited[x-1][y]){
            if(grid[x-1][y]==1){
                return level;
            }
            else{
                que.addLast(new pair(x-1,y));
                visited[x-1][y]=true;
            }
        }
        if(y>0  && !visited[x][y-1]){
            if(grid[x][y-1]==1){
                return level;
            }
            else{
                que.addLast(new pair(x,y-1));
                visited[x][y-1]=true;
            }
        }
        if(x<grid.length-1  && !visited[x+1][y]){
            if(grid[x+1][y]==1){
                return level;
            }
            else{
                que.addLast(new pair(x+1,y));
                visited[x+1][y]=true;
            }
        }
        if(y<grid[0].length-1 && !visited[x][y+1]){
            if(grid[x][y+1]==1){
                return level;
            }
            else{
                que.addLast(new pair(x,y+1));
                visited[x][y+1]=true;
            }
           
        }        
            }
            level++;        
}
        return -1;  
    }
    public void dfs(int[][] grid,boolean[][] visited, int x,int y,LinkedList<pair> que){
        visited[x][y]=true;
        que.addLast(new pair(x,y));
        
        if(x>0 && grid[x-1][y]==1 && !visited[x-1][y]){
            dfs(grid,visited,x-1,y,que);
        }
        if(y>0 && grid[x][y-1]==1 && !visited[x][y-1]){
            dfs(grid,visited,x,y-1,que);
        }
        if(x<grid.length-1 && grid[x+1][y]==1 && !visited[x+1][y]){
            dfs(grid,visited,x+1,y,que);
        }
        if(y<grid[0].length-1 && grid[x][y+1]==1 && !visited[x][y+1]){
            dfs(grid,visited,x,y+1,que);
        }
        
        
        
    }
}