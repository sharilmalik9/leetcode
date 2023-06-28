// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
       int[][] l= new int[profit.length][3]; 
        for(int i=0;i<profit.length;i++){
            l[i]=new int[]{startTime[i],endTime[i],profit[i]};
            
        }
        Arrays.sort(l,(a,b)-> a[0]-b[0]);
        return help(l,0);
    }
    public int help(int[][] l,int i){
        if(i>=l.length){
            return 0;
        }
        int profit=0;
        // int start=i+1;
        // int end=l.length-1;
        // while(start<=end){
        //     int mid=(start+end)/2;
        // }
        int idx=i+1;
        for(;idx<l.length;idx++){
            if(l[i][1]<=l[idx][0]){
                break;
            }
            
        }
        profit=Math.max(help(l,i+1),l[i][2]+help(l,idx));
        return profit;
    }
}