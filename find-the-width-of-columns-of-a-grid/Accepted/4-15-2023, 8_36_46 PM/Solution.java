// https://leetcode.com/problems/find-the-width-of-columns-of-a-grid

class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans= new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++){
            int cirr=0;
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]>0){
                    int curr=grid[j][i];
                    int len=0;
                    while(curr>0){
                        curr=curr/10;
                        len++;
                    }   
                cirr=Math.max(len,cirr);
                    
                }
                else{
                    int len=0;
                    int curr=Math.abs(grid[j][i]);
                    while(curr>0){
                        curr=curr/10;
                        len++;
                    }
                    len++;
                    cirr=Math.max(cirr,len);   
                } 
               
            }
            ans[i]=cirr;
        }
        return ans;
    }
}