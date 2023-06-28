// https://leetcode.com/problems/redundant-connection

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        boolean[] vis= new boolean[1001];
        int[] ans=new int[2];
        for(int[] i :edges){
            if(vis[i[0]] && vis[i[1]]){
                ans=i;
               
            }
            else{
                vis[i[0]]=true;
                vis[i[1]]=true;
            }
        }
        return ans;
        
    }
}