// https://leetcode.com/problems/number-of-operations-to-make-network-connected

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[][] arr=connections;
       
        if(arr.length<n-1){
            return -1;
        }
        
        int m=arr.length;
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        
        int ct=0;
        boolean[] vis=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ct++;
                dfs(adj,i,vis);
            }
        }
        
        return ct-1;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int cur, boolean[] vis){
        vis[cur]=true;
        
        for(int e: adj.get(cur)){
            if(!vis[e]){
                dfs(adj,e,vis);
            }
        }
    
        
    }
}