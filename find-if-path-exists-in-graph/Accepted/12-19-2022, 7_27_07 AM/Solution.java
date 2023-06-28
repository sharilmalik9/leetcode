// https://leetcode.com/problems/find-if-path-exists-in-graph

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        final boolean[] visited = new boolean[n];
        final Queue<Integer> bfsQueue = new LinkedList<Integer>();
        bfsQueue.add(start);
        visited[start] = true;
        while(!bfsQueue.isEmpty()) {
            final int currentVertex = bfsQueue.poll();
            if(currentVertex == end) {
                return true;
            }
            final Set<Integer> neighbors = findNeighbors(edges, n, currentVertex);
            for(final int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    bfsQueue.add(neighbor);
                }
            }
        }
        return false;
    }
    
    private static Set<Integer> findNeighbors(int[][] edges, int n, int v) {
        final Set<Integer> neighbors = new HashSet<Integer>();
        for(int[] edge : edges) {
            if(edge[0] == v) {
                neighbors.add(edge[1]);
            } else if(edge[1] == v) {
                neighbors.add(edge[0]);
            }
        }
        return neighbors;
    }
}