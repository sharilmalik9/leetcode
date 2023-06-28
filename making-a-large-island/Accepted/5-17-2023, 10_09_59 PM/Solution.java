// https://leetcode.com/problems/making-a-large-island

// store the computed sizes and then for all zeroes add pre computed from all 4 dirs and +1 
// give id to all uniq groups
class Solution {
    public int largestIsland(int[][] grid) {
        int max = 0;
        int id=1;
        int max1=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    id++;
                    int island = dfs(grid, i, j,id);
                    hm.put(id,island);
                    max1=Math.max(max1,island);
                    
                }
            }
        }

        int zeros=0;
        for(int i = 0 ; i < grid.length ; i++){
        
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0){
                    zeros++;
                    
                    int island = dfs2(grid, i, j,hm);
                    max=Math.max(max,island);
                    
                    
                }
            }
        }

         if(zeros==0){
             return max1;
         }
        return max;



    }
    int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    
    public int dfs(int[][] grid, int i, int j,int id){
        
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j]==0 || grid[i][j]==id){
            return 0;
        }
        
        
        int count = 1;
        grid[i][j] = id;
        for(int k = 0 ; k < dir.length ; k++){
            count += dfs(grid, i+dir[k][0], j+dir[k][1],id);

        }
        return count;
    }
    public int dfs2(int[][] grid, int i, int j,HashMap<Integer,Integer> hm){
        int ans=1;
        HashSet<Integer> hs= new HashSet<>();
        if(i>0){
            hs.add(grid[i-1][j]);
        }
        if(j>0){
             hs.add(grid[i][j-1]);
        }
        if(i<grid.length-1){
           hs.add(grid[i+1][j]);
        }
        if(j<grid[0].length-1){
            hs.add(grid[i][j+1]);
        }
         
        for (int k: hs) {
            ans+=hm.getOrDefault(k,0);
        }
        return ans;
    }
}