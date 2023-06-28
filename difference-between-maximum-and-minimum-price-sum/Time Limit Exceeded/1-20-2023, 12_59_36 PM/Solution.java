// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<List<Integer>> ls= new ArrayList<>();
        HashMap<String,Integer> dp= new HashMap<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            ls.get(edges[i][0]).add(edges[i][1]);
            ls.get(edges[i][1]).add(edges[i][0]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
           int curr=dfs(ls,i,-1,price,dp);
           ans=Math.max(ans,curr-price[i]);
        }
        return ans;
    }
    public int dfs(List<List<Integer>> ls,int curr,int parent,int[] val,HashMap<String,Integer> dp){
        int now=0;
        
        for(int i: ls.get(curr)){
            String str= i +"_" + curr;
            if(i==parent){
                continue;
            }
            if(i!=parent){
                if(dp.get(str)==null){
                    dp.put(str,dfs(ls,i,curr,val,dp));
                }

            }
            now=Math.max(dp.get(str),now);
        }
        return now+val[curr];

    }
}