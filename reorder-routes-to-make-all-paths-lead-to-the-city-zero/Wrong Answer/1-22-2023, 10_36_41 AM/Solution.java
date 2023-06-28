// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

class Solution {
    int ans=0;
     boolean[] vis;
    public int minReorder(int n, int[][] connections){
       
        List<List<Integer>> ls= new ArrayList<>();
        vis=new boolean[n];
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] curr : connections ){
            ls.get(curr[0]).add(curr[1]);
            if(curr[1]==0){
                vis[curr[0]]=true;
            }
        }
        vis[0]=true;
        for(int i:ls.get(0)){
            ans++;
            vis[i]=true;
        }
        for(int i=1;i<n;i++){
            dfs(ls,i);

        }
          
        return ans;
    }
    public void dfs(List<List<Integer>> ls, int i){
        
        if(!vis[i]){
            for(int j :ls.get(i)){
                if(vis[j]){
                    vis[i]=true;
                    break;
                }
                
            }
        }
        for(int j: ls.get(i)){
            if(!vis[j]){
                vis[j]=true;
                ans++;
            }
            dfs(ls,j);
        }
       

    }
}