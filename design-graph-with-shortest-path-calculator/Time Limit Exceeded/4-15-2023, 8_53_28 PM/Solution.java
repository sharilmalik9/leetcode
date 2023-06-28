// https://leetcode.com/problems/design-graph-with-shortest-path-calculator

class Graph {  
        int V ;
 int INF = Integer.MAX_VALUE;
 int[][] graph;
    public Graph(int n, int[][] edges) {
       
        V=n;
       graph=new int[n][n];
         for(int i=0;i<n;i++){
            Arrays.fill(graph[i],Integer.MAX_VALUE);
        }
        for(int[] i : edges){
            graph[i[0]][i[1]]=i[2];
        }
       
        
    }
    
    public void addEdge(int[] edge) {
        graph[edge[0]][edge[1]]=edge[2];
        
    }
    
    public int shortestPath(int node1, int node2) {
        boolean visited[] = new boolean[V];
        visited[node1] = true;
       int ans= minimumCostSimplePath(node1, node2, visited, graph);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
        
        
    }
     int minimumCostSimplePath(int u, int destination,
                                 boolean visited[],
                                 int graph[][])
{
     
    // Check if we find the destination
    // then further cost will be 0
    if (u == destination)
        return 0;
         
    // Marking the current node as visited
    visited[u] = true;
 
    int ans = INF;
 
    // Traverse through all
    // the adjacent nodes
    for(int i = 0; i < V; i++)
    {
        if (graph[u][i] != INF && !visited[i])
        {
             
            // Cost of the further path
            int curr = minimumCostSimplePath(i,
                        destination, visited, graph);
 
            // Check if we have reached the
            // destination
            if (curr < INF)
            {
                 
                // Taking the minimum cost path
                ans = Math.min(ans, graph[u][i] + curr);
            }
        }
    }
 
    // Unmarking the current node
    // to make it available for other
    // simple paths
    visited[u] = false;
 
    // Returning the minimum cost
    return ans;
}  
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */