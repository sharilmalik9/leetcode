// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix

class Solution {
    public int countNeg(int[] level){
        int s=0, e=level.length -1;
        while(s<=e){
            int mid=(s+e)/2;
            if(level[mid]>=0){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        //count of positive number = s
        // so return count of negetive number = len of level - s ;
        return level.length-s;
    }
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int ans=0;
        for(int i=0; i<n; ++i){
            ans+=countNeg(grid[i]);
        }
        return ans;
    }
}