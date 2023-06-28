// https://leetcode.com/problems/largest-divisible-subset

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] hash=new int[nums.length];
        int max=1;
        int maxidx=0;
        for(int i=0;i<nums.length;i++) hash[i]=i;
         Arrays.fill(dp,1);
         for(int i=0;i<nums.length;i++){
             for(int j=0;j<i;j++){
                 if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                     dp[i]=dp[j]+1;
                     hash[i]=j;
                 }
                 if(max<dp[i]){
                 max=dp[i];
                 maxidx=i;
             }   
             }
             
         }
         List<Integer> ans=new ArrayList<>();
          ans.add(nums[maxidx]);
         while(hash[maxidx]!=maxidx){
                          maxidx=hash[maxidx];

             ans.add(nums[maxidx]);
         }
         System.out.println(ans);
        // return Collections.reverse(ans);
       return ans;  
    }
}