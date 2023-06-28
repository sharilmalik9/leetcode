// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>(); //Weighted Graph
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());  //Initialse the  graph
        for(int[] e: roads){  //Fill the graph
            graph.get(e[0]-1).add(new int[]{e[1]-1,e[2]});
            graph.get(e[1]-1).add(new int[]{e[0]-1,e[2]});
        }
        return getMin(0,new boolean[n],graph); //Single DFS
    }
    private int getMin(int node, boolean[] visited,List<List<int[]>> graph){
        int min = Integer.MAX_VALUE;
        visited[node] = true;
        for(int[] child: graph.get(node)){
            min = Math.min(min,child[1]); //Check if this edge is minimum or not;
            if(!visited[child[0]]){
                 min = Math.min(min,getMin(child[0],visited,graph));
            }
        }
        return min;
    }
}