// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
         List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean vis[]=new boolean[n];
        return dfs(adj,vis,hasApple,n,0);
    }
    public int dfs(List<List<Integer>>adj,boolean vis[],List<Boolean> hasApple,int n,int i){
        vis[i]=true;
        int cnt=0;
        for(int e: adj.get(i)){
            if(!vis[e]){
                cnt+=dfs(adj,vis,hasApple,n,e);
            }
        }
        if(i==0){
            return cnt;
        }
        return cnt + ((cnt>0 || hasApple.get(i)) ? 2 :0);
    }
}