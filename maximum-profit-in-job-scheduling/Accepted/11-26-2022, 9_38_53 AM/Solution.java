// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
       int[][] l= new int[profit.length][3]; 
        for(int i=0;i<profit.length;i++){
            l[i]=new int[]{startTime[i],endTime[i],profit[i]};
            
            
        }
        int[] dp= new int[l.length];
        Arrays.fill(dp,-1);
        Arrays.sort(l,(a,b)-> a[0]-b[0]);
        return help(l,0,dp);
    }
    public int help(int[][] l,int i,int[] dp){
        if(i>=l.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int profit=0;
        int start=i+1;
        int end=l.length-1;
        int idx=end+1;
        while(start<=end){
            int mid=(start+end)/2;
            if(l[mid][0]>=l[i][1]){
                idx=mid;
                end=mid-1;
               
            }
            else{
                start=mid+1;
            }
           
        }
       
        profit=Math.max(help(l,i+1,dp),l[i][2]+help(l,idx,dp));
        return dp[i]=profit;
    }
}