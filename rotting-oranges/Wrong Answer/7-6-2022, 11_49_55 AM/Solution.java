// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
          int good=0;
        Queue<Integer[]> que= new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    Integer[] element= new Integer[2];
                    element[0]=i;
                    element[1]=j;
                    que.add(element);
                }
                if(grid[i][j]==1){
                    good++;
                }
            }
        }
        if(que.size()==0){
            return -1;
        }
        if(good==0){
            return 0;
        }
        int time=0;
        while (!que.isEmpty()){
            int size=que.size();
            int count=0;
            for(int i=0;i<size;i++){
              Integer[] curr=que.poll();
              int x=curr[0];

              int y=curr[1];
              if(x>0){
                  if(grid[x-1][y]==1){
                      grid[x-1][y]=2;
                      Integer[] neww= new Integer[2];
                      neww[0]=x-1;
                      neww[1]=y;
                      que.add(neww);
                      count++;
                  }
              }
              if(x<grid.length-1){
                  if(grid[x+1][y]==1){
                      grid[x+1][y]=2;
                      Integer[] neww= new Integer[2];
                      neww[0]=x+1;
                      neww[1]=y;
                      que.add(neww);
                      count++;

                  }
              }
                if(y>0){
                    if(grid[x][y-1]==1){
                        grid[x][y-1]=2;
                        Integer[] neww= new Integer[2];
                        neww[0]=x;
                        neww[1]=y-1;
                        que.add(neww);
                        count++;
                    }
                }
                if(y<grid[0].length-1){
                    if(grid[x][y+1]==1){
                        grid[x][y+1]=2;
                        Integer[] neww= new Integer[2];
                        neww[0]=x;
                        neww[1]=y+1;
                        que.add(neww);
                        count++;

                    }
                }
            }
            if(count>0){
                time++;
            }

        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}