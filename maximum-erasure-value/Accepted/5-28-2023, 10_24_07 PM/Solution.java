// https://leetcode.com/problems/maximum-erasure-value

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
            
        }
        int start=0;
        int end=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        hm.put(nums[0],0);
        int ans=0;
        while(end<nums.length-1){
            end++;
            if(hm.containsKey(nums[end]) && hm.get(nums[end])>=start){
                ans=Math.max(ans,sum(start,end-1,sum,nums));
                start=hm.get(nums[end])+1;
                hm.remove(nums[end]);

            }
            hm.put(nums[end],end);

        }
        ans=Math.max(sum(start,end,sum,nums),ans);
        return ans;
    }
    public int sum(int start,int end,int[] sum,int[] nums){
          return sum[end]-sum[start]+nums[start];
    }
}