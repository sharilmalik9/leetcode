// https://leetcode.com/problems/burst-balloons

class Solution {
    int dp[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i=0;i<n;i++) list.add(nums[i]);
        list.add(1);
        
        dp = new int[n+2][n+2];
        
        for (int i=0;i<n+2;i++) Arrays.fill(dp[i],-1);
        return helper_max_coins(1,n,list);
    }
    
    private int helper_max_coins(int i,int j,List<Integer> list){
        if (i>j) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int maxi = Integer.MIN_VALUE;
        
        for (int ind=i;ind<=j;ind++){
            
            int costs = list.get(i-1) * list.get(ind) * list.get(j+1) // very very deep condition pls seee video again for this 
                          + helper_max_coins(i,ind-1,list)   // left partition
                          + helper_max_coins(ind+1,j,list);  // right partition
            maxi = Math.max(maxi,costs);
        }
        return dp[i][j] = maxi;
    }
}
