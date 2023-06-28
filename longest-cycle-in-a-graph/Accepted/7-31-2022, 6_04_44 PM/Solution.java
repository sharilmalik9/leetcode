// https://leetcode.com/problems/longest-cycle-in-a-graph

class Solution {
    public int longestCycle(int[] edges) {
    int n = edges.length;
    int ans = -1;
    boolean[] visited = new boolean[n];
    for(int i = 0 ; i < n ; i++){
        if(visited[i])continue;
        HashMap<Integer , Integer> d = new HashMap<>();
        // visited[i] = true;
        // d.put(i , 0);
        int x = dfs(edges , i , 0 , visited ,i , d);
        if(x != -1)ans = Math.max(ans , x);
    }
    return ans;
}
public int dfs(int[] edges , int node , int dis , boolean[] visited , int start ,HashMap<Integer , Integer> d ){
    if(node == -1)return -1;
    // if(node == start)return dis;
    if(visited[node] ){
        if(!d.containsKey(node))return -1;
        return dis - d.get(node);
    }
    visited[node] = true;
    d.put(node , dis);
    return dfs(edges , edges[node] , dis+1 , visited ,start ,d);
    
}
}