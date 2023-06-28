// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden

class Solution {
    public int minTaps(int n, int[] ranges) {
       int[][] range= new int[n+1][2];
       for(int i=0;i<n+1;i++){
           range[i][0]=i - ranges[i];
           range[i][1]=i + ranges[i];
       }
       Arrays.sort(range,(a,b)-> a[0]-b[0]);
       int min=0;
       int max=0;
       int index=0;
       int total=0;
       while(max<n){
           while(index<n+1 && range[index][0]<=min){
               max=Math.max(range[index][1],max);
               index++;
           }
           if(min==max && min>=0){
               return -1;
           }
           total++;
           min=max;
       }

        return total;
    }
}