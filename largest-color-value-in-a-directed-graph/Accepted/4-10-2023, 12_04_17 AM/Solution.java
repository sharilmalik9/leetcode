// https://leetcode.com/problems/largest-color-value-in-a-directed-graph

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        graph.add(new ArrayList<Integer>());
        for(int[] edge : edges){
            int a=edge[0];
            int b=edge[1];
            graph.get(a).add(b);
        }

        int[][] dp=new int[n][26];
        boolean[] vis=new boolean[n];
        int ans=0;      
        
        for(int i=0;i<n;i++){
//if i is not visited do dfs
            if(!vis[i] && dfs(i,graph,dp,vis,new boolean[n],colors))
            return -1;
            for(int k : dp[i])
            ans=Math.max(ans,k);

        }
        return ans;
    }
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> graph,int[][] dp,boolean[] vis,boolean[] dfsvis,
    String colors){
        vis[node]=true;
        dfsvis[node]=true;

        for(int val : graph.get(node)){
// return true if loop
            if(dfsvis[val])
            return true;
// do dfs if not visited i.e if visited dfs is already done
            if(!vis[val] && dfs(val,graph,dp,vis,dfsvis,colors))
            return true; 
                   
          for(int i=0;i<26;i++)
          dp[node][i]=Math.max(dp[node][i],dp[val][i]);
        }
        dfsvis[node]=false;
         dp[node][colors.charAt(node)-'a']++;
         return false;
    }
   
}