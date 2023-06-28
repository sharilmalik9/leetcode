// https://leetcode.com/problems/number-of-good-paths

class Solution {
    int good=0;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        List<List<Integer>> ls= new ArrayList<>();
        for(int i=0;i<vals.length;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            ls.get(edges[i][0]).add(edges[i][1]);
            ls.get(edges[i][1]).add(edges[i][0]);
        }
       
        for(int i=0;i<vals.length;i++){
             boolean[] visited=new boolean[vals.length];
             dfs(ls,vals,i,i,visited);

        }
        return good/2 + vals.length;
        
    }
    public void dfs(List<List<Integer>> ls, int[] vals,int start,int curr,boolean[] visited){
        if(curr!=start && vals[start]==vals[curr]){
            good++;

        }
        visited[curr]=true;
        for(int i: ls.get(curr)){
            if(!visited[i] && vals[i] <=vals[start]){
                dfs(ls,vals,start,i,visited);
            }
        }
    }
}