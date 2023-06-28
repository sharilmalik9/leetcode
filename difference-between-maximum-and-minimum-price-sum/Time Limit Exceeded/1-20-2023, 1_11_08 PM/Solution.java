// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        Map<Integer, Long>[] adjList = new Map[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new HashMap<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].put(edge[1], 0L);
            adjList[edge[1]].put(edge[0], 0L);
        }
        // Above we simply construct the adjacency list for the given tree.
        long res = 0;
        // Below, we dfs every node of our tree,
        // but every iteration won't be O(n),
        // because we use information from previous dfs iteration
        // to compute edge values.
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(adjList, price, i, -1) - price[i]);
        }
        return res;
    }
    
    private long dfs(Map<Integer, Long>[] tree, int[] price, int cur, int parent) {
        long maxPath = 0;
        for (int child : tree[cur].keySet()) {
            if (child != parent) {
                // get the weight of edge from node cur to node child.
                long temp = tree[cur].get(child);

                // if the weight of the edge is not already computed,
                // then we compute by calling dfs for this
                // adjacent or child node.
                if (temp == 0) {
                    temp = dfs(tree, price, child, cur);
                    tree[cur].put(child, temp);
                }
                // maxPath starting from node cur is updated.
                maxPath = Math.max(maxPath, temp);
            }
        }
        // cost of including current path in previous
        // stack call is returned.
        return maxPath + price[cur];
    }
}