// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!call(graph,color,0,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean call(int[][] graph,int[] color,int col,int node){
            color[node]=col;
            for(int i: graph[node]){
                if(color[i]==-1){
                    if(!call(graph,color,1-col,i)){
                        return false;
                    }
                }
                else if(color[i]==col){
                    return false;
                }

            }
        return true;
    }
}