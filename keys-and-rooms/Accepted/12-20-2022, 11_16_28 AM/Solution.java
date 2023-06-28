// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis= new boolean[rooms.size()];
        dfs(rooms,vis,0);
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;
    }
    public void dfs(List<List<Integer>> rooms,boolean[] vis,int i){
        if(vis[i]){
            return;
        }
        vis[i]=true;
        for(int j: rooms.get(i)){
            dfs(rooms,vis,j);
        }
    }
}