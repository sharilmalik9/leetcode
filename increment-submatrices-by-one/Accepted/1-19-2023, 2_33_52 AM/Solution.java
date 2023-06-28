// https://leetcode.com/problems/increment-submatrices-by-one

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans= new int[n][n];
        for(int i=0;i<queries.length;i++){
            int row1=queries[i][0];
            int col1=queries[i][1];
            int row2=queries[i][2];
            int col2=queries[i][3];
            for(int j=row1;j<=row2;j++){
                for(int k=col1;k<=col2;k++){
                    ans[j][k]++;
                }
            }
        }
        return ans;
    }
}