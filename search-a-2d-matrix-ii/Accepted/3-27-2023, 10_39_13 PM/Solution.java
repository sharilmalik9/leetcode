// https://leetcode.com/problems/search-a-2d-matrix-ii

class Solution {
    public boolean searchMatrix(int[][] mat, int t) {
        int r=0;
        int c=mat[0].length-1;

        while(c>=0 && r<mat.length){
            if(mat[r][c]==t)return true;
            
            if(mat[r][c]<t)r++;
            else c--;
            
        }
        return false;
    }
}