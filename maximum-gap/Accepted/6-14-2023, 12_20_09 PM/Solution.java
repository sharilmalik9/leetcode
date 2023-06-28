// https://leetcode.com/problems/maximum-gap

// vv new concept
// bucket using 
// watch video 
class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1){
            return 0;
        }
       int min=nums[0];
       int max=0;
       for(int i=0;i<nums.length;i++){
           min=Math.min(min,nums[i]);
           max=Math.max(max,nums[i]);
       }
       int interval=(int)Math.ceil((max-min+0.0)/(n-1));
       int[] minbucket=new int[n-1];
       int[] maxbucket=new int[n-1];
       Arrays.fill(minbucket,Integer.MAX_VALUE);
       Arrays.fill(maxbucket,-1);
       int ans=0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]==min || nums[i]==max){
               continue;
           }
           int idx=(nums[i]-min)/interval;

          minbucket[idx]=Math.min(minbucket[idx],nums[i]);
          maxbucket[idx]=Math.max(maxbucket[idx],nums[i]);

       }
    int prev=min;
    for(int i=0;i<n-1;i++){
        if(maxbucket[i]==-1){
            continue;

        }
        ans=Math.max(-prev+minbucket[i],ans);
        prev=maxbucket[i];
    }
       ans=Math.max(ans,max-prev);
       return ans;  
    }
}