// https://leetcode.com/problems/find-eventual-safe-states

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      /*
      
      If we observe question nearly, we first have to find the cycle and all the nodes which are included in the cycle because these are the nodes that are not safe nodes
      
      because from a node if we can reach to any other node which is not a terminal node then that node is not a safer node
      
      so we can use dfs for finding every node included in the cycle
      
      and return the nodes which are not a part of cylce
      
      */
        
        //create adjancey list
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int n = graph.length;
        
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<Integer>());
            for(int j = 0; j<graph[i].length; j++)
                    adj.get(i).add(graph[i][j]);
        }
     
        //for checking which node is a part of cylce
        boolean[] cycle_nodes = new boolean[n];
        Arrays.fill(cycle_nodes, false);
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        boolean[] dfsVisited = new boolean[n];
        Arrays.fill(dfsVisited, false);
        
        
        for(int i = 0; i<n; i++){
            if(visited[i] == false){
                dfsCycleCheck(i, adj, visited, dfsVisited, cycle_nodes);
            }
        }
        
        ArrayList<Integer> safeNodes = new ArrayList<Integer>();
        
        for(int i = 0; i<cycle_nodes.length; i++){
            if(cycle_nodes[i] == false)
                safeNodes.add(i);
        }
        
        return safeNodes;
    }
    
    private boolean dfsCycleCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited, boolean[] cycleNodes){
        visited[node] = true;
        dfsVisited[node] = true;
        
        
        for(Integer adjNode : adj.get(node)){
            if(visited[adjNode] == false){
                if(dfsCycleCheck(adjNode, adj, visited, dfsVisited, cycleNodes) == true)
                    return cycleNodes[node] = true; //it shows that node is a part of cycle 
            }
                else if(visited[adjNode] == true && dfsVisited[adjNode] == true)
                    return cycleNodes[node] = true;
            
        }
        dfsVisited[node] = false;
        return false;
    }
}