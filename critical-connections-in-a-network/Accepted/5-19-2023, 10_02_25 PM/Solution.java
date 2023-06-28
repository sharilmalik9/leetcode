// https://leetcode.com/problems/critical-connections-in-a-network

class Solution {
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ls= new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            ls.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            ls.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        int[] tre= new int[n];
        int[] low=new int[n];
        boolean[] vis=new boolean[n];
        dfs(ls,-1,tre,low,vis,0,1,ans);
        return ans;
    }
    public void dfs(List<List<Integer>> ls,int parent,int[] tre,int[] low, boolean[] vis,int curr,int val,List<List<Integer>> ans){
        vis[curr]=true;
        tre[curr]=low[curr]=val;
        val++;
        for(int i: ls.get(curr)){
            if(i==parent){
                continue;
            }
            if(!vis[i]){
                dfs(ls,curr,tre,low,vis,i,val,ans);
                low[curr]=Math.min(low[curr],low[i]);
                if(low[i]>tre[curr]){
                    List<Integer> oh= new ArrayList<>();
                    oh.add(i);
                    oh.add(curr);
                    ans.add(oh);

                }
            }
            else{
                low[curr]=Math.min(low[curr],low[i]);
            }
        }
    }
}