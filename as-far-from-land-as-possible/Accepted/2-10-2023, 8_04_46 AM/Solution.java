// https://leetcode.com/problems/as-far-from-land-as-possible

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int mh = grid.length;
        int mw = grid[0].length;
        boolean[][] added = new boolean[mh][mw];
        int numberOfIslands = 0;

        for (int i = 0; i < mh; i++) {
            for (int j = 0; j < mw; j++) {
//Add each 1 to queue
                if(grid[i][j]==1){
                    numberOfIslands++;
                    added[i][j]=true;
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(numberOfIslands==mh*mw){
            return -1;
        }

        int steps=-1;
        
        while(!queue.isEmpty()){
            int k = queue.size();
//Increase number of steps for each bfs step
            steps++;
            for (int i = 0; i < k; i++) {
                int[] coordinates = queue.poll();
//Check 4-directional neighbors
                helper(queue,added, coordinates[0]+1, coordinates[1], mw, mh);
                helper(queue,added, coordinates[0]-1, coordinates[1], mw, mh);
                helper(queue,added, coordinates[0], coordinates[1]+1, mw, mh);
                helper(queue,added, coordinates[0], coordinates[1]-1, mw, mh);
            }
        }
        return steps;
    }

    public static void helper(Queue<int[]> queue,boolean[][] added, int i, int j, int l, int k){
        if(i<0 || i>=l || j>=k || j<0 || added[i][j]){
            return;
        }
        added[i][j]=true;
        queue.add(new int[]{i,j});
    }
}
