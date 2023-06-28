// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    HashMap<Integer, List<Integer>> adj;
    int[] price;
    HashMap<Pair<Integer, Integer>, Long> memo = new HashMap<>();
    
    public long maxOutput(int n, int[][] edges, int[] price) {
        // edge case
        if(n == 1) return 0;
        
        adj = new HashMap<>();
        this.price = price;
        int[] degree = new int[n];  // record the degree of each node, those with degree 1 are leaf nodes
        
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            
            adj.putIfAbsent(a, new ArrayList<Integer>());
            adj.putIfAbsent(b, new ArrayList<Integer>());
            
            adj.get(a).add(b);
            adj.get(b).add(a);
            
            degree[a] ++;
            degree[b] ++;
        }
        
        long ans = 0;
        // dfs with leaf node(degree 1) 
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dfs(i, -1) - price[i]);
        }
        
        return ans;
        
        
    }
    
    public long dfs(int node, int pre){
        // reaches a leaf node
        if(adj.get(node).size() == 1 && adj.get(node).get(0) == pre){  
            return price[node];
        }
        
        //memorization
        Pair<Integer, Integer> pair = new Pair<>(node, pre);
        if(memo.containsKey(pair)) return memo.get(pair);
        
        long s = 0;
        for(Integer child:adj.get(node)){
            if(child == pre) continue;
            
            s = Math.max(s, dfs(child, node));
            
        }
        
        //update memo
        memo.put(pair, price[node] + s);
        
        return price[node] + s;    
    }
}