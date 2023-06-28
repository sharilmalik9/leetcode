// https://leetcode.com/problems/shortest-path-with-alternating-colors

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
      List<List<List<Integer>>> ls= new ArrayList<>();
      for(int i=0;i<n;i++){
          ls.add(new ArrayList<>());
          ls.get(i).add(new ArrayList<>());
          ls.get(i).add(new ArrayList<>());
      }
      for (int[] edge : redEdges) {
            ls.get(edge[0]).get(0).add(edge[1]);     
        }
        for (int[] edge : blueEdges) {
            ls.get(edge[0]).get(1).add(edge[1]);   
        } 
        int[] ans= new int[n];
        Arrays.fill(ans,-1);
        Queue<int[]> que= new LinkedList<>();
        boolean[][] vis= new boolean[2][n];
        que.add(new int[]{0,0,0});
        que.add(new int[]{0,1,0});
        while(que.size()>0){
            int[] curr= que.poll();
            int node=curr[0];
            int color=curr[1];
            int dis=curr[2];
            if(vis[color][node]){
                continue;

            }
            vis[color][node]=true;
            if(ans[node]==-1){
                ans[node]=dis;
            }
            for(int neigh :ls.get(node).get(color)){
                int nextcolor=color==0 ? 1 :0;
                if(!vis[nextcolor][neigh]){
                    que.add(new int[]{neigh,nextcolor,dis+1});
                }
            }


        }
        return ans; 

    }
}