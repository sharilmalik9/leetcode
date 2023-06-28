// https://leetcode.com/problems/maximum-strictly-increasing-cells-in-a-matrix

class Solution {

    public int maxIncreasingCells(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        TreeMap<Integer,List<int[]>> tm=new TreeMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=mat[i][j];
                if(tm.containsKey(val)){
                    tm.get(val).add(new int[] {i,j});
                }
                else{
                    List<int[]> ls=new ArrayList<>();
                    ls.add(new int[] {i,j});
                    tm.put(val,ls);
                }
            }
        }
        int[][] dp=new int[m][n];
        int[] row=new int[m];
        int[] col=new int[n];
        for(int val:tm.keySet()){
            for(int[] arr:tm.get(val)){
                int x=arr[0];
                int y=arr[1];
                dp[x][y]=Math.max(row[x],col[y])+1;
            }
            for(int[] arr:tm.get(val)){
                int x=arr[0];
                int y=arr[1];
                row[x]=Math.max(row[x],dp[x][y]);
                col[y]=Math.max(col[y],dp[x][y]);
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}