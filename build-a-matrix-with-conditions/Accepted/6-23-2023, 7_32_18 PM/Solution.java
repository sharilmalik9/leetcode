// https://leetcode.com/problems/build-a-matrix-with-conditions

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowTopologicalOrder = getTopologicalOrder(rowConditions, k);
        if (rowTopologicalOrder.isEmpty()) 
            return new int[0][0]; // Cycle detected

        List<Integer> colTopologicalOrder = getTopologicalOrder(colConditions, k);
        if (colTopologicalOrder.isEmpty()) 
            return new int[0][0]; // Cycle detected

        Map<Integer, Integer> colOrderIndexMap = new HashMap<>();
        for (int i = 0; i < k; i++)
            colOrderIndexMap.put(colTopologicalOrder.get(i), i);

        int[][] result = new int[k][k];
        for (int i = 0; i < k; i++)
            result[i][colOrderIndexMap.get(rowTopologicalOrder.get(i))] = rowTopologicalOrder.get(i);
        return result;
    }

    private List<Integer> getTopologicalOrder(int[][] edges, int k) {
        Map<Integer, List<Integer>> adjList = buildGraph(edges);
        List<Integer> topologicalOrder = new ArrayList<>();
        int[] visited = new int[k + 1];
        for (int i = 1; i <= k; i++)
            if (!dfs(i, adjList, visited, topologicalOrder)) 
                return Collections.emptyList(); // Cycle detected
        return topologicalOrder;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    // Topological order + Cycle detection
    private boolean dfs(int node, Map<Integer, List<Integer>> graph, int[] visited, List<Integer> topologicalOrder) {
        if (visited[node] == 1) return true;
        if (visited[node] == -1) return false;
        visited[node] = -1;

        for (int neighbour : graph.getOrDefault(node, Collections.emptyList()))
            if (!dfs(neighbour, graph, visited, topologicalOrder)) return false;

        visited[node] = 1;
        topologicalOrder.add(node);
        return true;
    }
}