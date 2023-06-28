// https://leetcode.com/problems/longest-path-with-different-adjacent-characters

class Solution {
    int res = 0;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
            graph[i].add(parent[i]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph, s, 0, visited);
        return res;
    }

    private int dfs(List<Integer>[] graph, String s, int cur, boolean[] visited) {
        if (visited[cur]) return 0;
        visited[cur] = true;
        int max = 0, secondMax = 0;
        for (int next : graph[cur]) {
            int val = dfs(graph, s, next, visited);
            if (s.charAt(cur) != s.charAt(next)) {
                if (val > secondMax) secondMax = val;
                if (secondMax > max) {
                    int tmp = secondMax;
                    secondMax = max;
                    max = tmp;
                }
            }
        }
        res = Math.max(res, max + secondMax + 1);
        return max + 1;
    }
}