// https://leetcode.com/problems/number-of-provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                Util(isConnected,visited,i);
                count++;
            }
           
            
        }
        return count;
    }
    public void Util(int[][] isConnected,boolean[] visited,int v){
        visited[v]=true;
        for(int i=0;i<isConnected[v].length;i++){
            if(isConnected[v][i]==1){
                if(!visited[i]){
                    Util(isConnected,visited,i);
                }
                
            }
            
        }
        
    }
}