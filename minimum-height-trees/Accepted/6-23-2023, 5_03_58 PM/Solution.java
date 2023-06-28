// https://leetcode.com/problems/minimum-height-trees

// vv good question 
// vv good concept
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // max mht can be 2 only -why ?-you have to find the centre of the graph
        // center can be 2 only 
        // how to find center-start from end and keep adding end elements and deleing remaining in last is the ans
          Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegree = new int[n];
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
      graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
      indegree[u]++;
      indegree[v]++;
    }

    // Find nodes with smallest incoming/outgoing edges
    int smallestIndegree = Integer.MAX_VALUE;
    for (int node = 0; node < n; node++)
      smallestIndegree = Math.min(smallestIndegree, indegree[node]);

    // Create a simple queue (initially used a priority queue but found it unneccesary)
    Queue<Integer> pq = new LinkedList<>();
    boolean[] visited = new boolean[n];

    // Add all the nodes with smallest number of edges into the queue
    // these nodes are the leaves
    for (int node = 0; node < n; node++)
      if (indegree[node] == smallestIndegree) {
        pq.offer(node);
        visited[node] = true;
      }

    List<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result = new ArrayList<>();

      // one level of the queue will be the "outermost" nodes
      // processed so far, so this "innermost" nodes will have longest paths
      for (int i = 0, size = pq.size(); i < size; i++) {
        int node = pq.poll();
        result.add(node);
        List<Integer> neighbors = graph.getOrDefault(node, Collections.emptyList());
        for (int neighbor : neighbors) {
          // when a node is processed, neighboring node will lose an edge
          indegree[neighbor]--;

          // if only one edge left for this neighbor, it is next in queue
          if (indegree[neighbor] <= 1 && !visited[neighbor]) {
            pq.offer(neighbor);
            visited[neighbor] = true;
          }
        }
      }
    }

    return result;
  }
        
        
    
}