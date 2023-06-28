// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        long res = 0;
       Map<String,Long> dp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i,-1,adj,dp,price) - price[i]);
        }
        return res;
    }
    
    private long dfs(int curr,int prev,List<List<Integer>> adj,Map<String,Long> dp,int[] prices) {
        long max = 0;
        for(int child:adj.get(curr)){
            String x = curr+"-"+child;
            if(child!=prev){
                if(dp.get(x)==null){
                    dp.put(x,dfs(child,curr,adj,dp,prices));
                }
                max=Math.max(max,dp.get(x));
            }
        }
        return max+prices[curr];
    }
}