// https://leetcode.com/problems/count-ways-to-group-overlapping-ranges

class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges,(a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int cnt=1;
        int start=ranges[0][0];
        int end=ranges[0][1];
        for(int i=0;i<ranges.length;i++){
            if(ranges[i][0]<=end){
                end=Math.max(ranges[i][1],end);
            }
            else{
                cnt++;
                start=ranges[i][0];
                end=ranges[i][1];
            }

        }
        return (int)Math.pow(2,cnt);
        
    }
}