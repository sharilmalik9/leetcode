// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    long res = 0;
    List<Integer>[] g;
    int[] price;

    record returnType(int withLeaf, int withoutLeaf) {}
    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        
        // create adjacency list graph(tree)
        g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (var e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(n > 2 ? 2 : 0, -1);
        return res;
    }

    private returnType dfs(int cur, int pre) {
        int withLeaf = price[cur], withoutLeaf = 0;
        for (int child : g[cur]) if (child != pre) {
            var childMax = dfs(child, cur);
            res = Math.max(res, withLeaf + childMax.withoutLeaf);
            res = Math.max(res, withoutLeaf + childMax.withLeaf);
            withLeaf = Math.max(withLeaf, childMax.withLeaf + price[cur]);
            withoutLeaf = Math.max(withoutLeaf, childMax.withoutLeaf + price[cur]);
        }

        return new returnType(withLeaf, withoutLeaf); // single leg
    }
}