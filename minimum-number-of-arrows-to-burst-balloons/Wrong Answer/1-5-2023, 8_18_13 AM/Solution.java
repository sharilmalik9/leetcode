// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> (a[0]==b[0]) ? a[1]-b[1] : a[0]-b[0]);
        int count=1;
      
        int start=points[0][0];
        int end=points[0][1];
       for(int i=1;i<points.length;i++){
           if(points[i][0] <= end){
               continue;
               //end=Math.max(points[i][1],end);
               
           }
           else{
               count++;
           start=points[i][0];
           end=points[i][1];
           }
         
       }
       return count;
    }
}