// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph

class Solution {
    public long countPairs(int n, int[][] edges){
        List<List<Integer>> graph= new ArrayList<>();
        boolean[] vis= new boolean[n];
        long ans=0;
        List<Integer> ls= new ArrayList<>();
        int sum=0;
        for(int i=0;i<n;i++){
           
            graph.add(new ArrayList<>());
        }
       for(int[] arr:edges){
           graph.get(arr[0]).add(arr[1]);
           graph.get(arr[1]).add(arr[0]);
       }
       for(int i=0;i<n;i++){
           if(!vis[i]){
               ls.add(dfs(graph,i,vis));
               sum+=ls.get(ls.size()-1);

           }
       }
      for(int i=0;i<ls.size();i++){
          sum=sum-ls.get(i);
          ans=ans+sum*ls.get(i);

      }


     return ans;
        
    }
    public int dfs(List<List<Integer>> graph,int i,boolean[] vis){
        vis[i]=true;
        int curr=1;
        for(int j:graph.get(i)){
            if(!vis[j]){
                curr+=dfs(graph,j,vis);
            }
        }
        return curr;

    }
}