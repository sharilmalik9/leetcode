// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<List<Integer>> ls= new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            ls.get(edges[i][0]).add(edges[i][1]);
            ls.get(edges[i][1]).add(edges[i][0]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
           int curr=dfs(ls,i,-1,price);
           ans=Math.max(ans,curr-price[i]);
        }
        return ans;
    }
    public int dfs(List<List<Integer>> ls,int curr,int parent,int[] val){
        int now=0;
        for(int i: ls.get(curr)){
            if(i==parent){
                continue;
            }
            now=Math.max(dfs(ls,i,curr,val),now);
        }
        return now+val[curr];

    }
}