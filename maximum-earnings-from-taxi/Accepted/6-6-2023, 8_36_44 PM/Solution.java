// https://leetcode.com/problems/maximum-earnings-from-taxi

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int[][] l=rides;
         long[] dp= new long[l.length];
        Arrays.fill(dp,-1);
        Arrays.sort(l,(a,b)-> a[0]==b[0]?a[1]-b[1] : a[0]-b[0]);
        return help(l,0,dp);
    }
    public long help(int[][] l,int i,long[] dp){
        if(i>=l.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long profit=0;
        int start=i+1;
        int end=l.length-1;
        int idx=end+1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(l[mid][0]>=l[i][1]){
                idx=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            } 
        }
        profit=Math.max(help(l,i+1,dp),l[i][2]+l[i][1]-l[i][0]+help(l,idx,dp));
        return dp[i]=profit;
    }
}