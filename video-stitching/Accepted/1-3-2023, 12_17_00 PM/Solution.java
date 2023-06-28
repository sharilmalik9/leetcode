// https://leetcode.com/problems/video-stitching

class Solution {
    public int videoStitching(int[][] clips, int time){
        int min=0;
        int max=0;
        int total=0;
        int index=0;
        Arrays.sort(clips, (a,b)-> a[0]-b[0]);
        if(clips[0][0]!=0){
            return -1;
        }
        while(max<time){
           while(index< clips.length && clips[index][0]<=min){
               max=Math.max(max,clips[index][1]);
               index++;
           }
           if(min==max){
               return -1;
           }
           min=max;
           total++;

        } 
        return total;
    }
}