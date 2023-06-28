// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii

class Solution {
    int[][] events;
    public int maxValue(int[][] events, int K) {
        int dp[][];
        this.events = events;
        dp = new int[events.length+1][K+1];
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        for(int i = events.length-1; i>=0; i--){
            for(int k = 1; k<=K; k++){
                // Attend the event
                int nextIdx = search(events[i][1], i+1, events.length-1);
                int attend = events[i][2];
                if(nextIdx != -1){
                    attend += dp[nextIdx][k-1];
                }

                // Dont attend the event 
                int notAttend = dp[i+1][k];

                dp[i][k] = Math.max(attend, notAttend);
            }
        }
        return dp[0][K];
    }


    // A function to search for the first event that starts after x
    // i.e search for the least value greater than x (Next greater element)
    public int search(int x, int i, int j){
        if(events[j][0] <= x) return -1;

        while(i<j){
            int mid = (j-i)/2 + i;
            
            if(events[mid][0] <= x){
                i = mid + 1;
            }else{
                j = mid;
            }
        }
        return j;
    }
}