// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> (a[0]==b[0]) ? a[1]-b[1] : a[0]-b[0]);
        int i=0;
        int ans=0;
        for(int j=1;j<intervals.length;j++){
            // overlap 
            if(intervals[i][1] >intervals[j][0]){
                ans++;
                if(intervals[i][1] >intervals[j][1]){
                    i=j;

                }

            }
            else{
                i=j;
            }

        }

        





     return ans;   
    }
}