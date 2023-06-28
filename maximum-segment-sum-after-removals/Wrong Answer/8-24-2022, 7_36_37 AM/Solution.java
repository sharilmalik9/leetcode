// https://leetcode.com/problems/maximum-segment-sum-after-removals

class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        long[] prefix= new long[nums.length];
        long[] suffix= new long[nums.length];
        long[] ans= new long[nums.length];
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(i==0) {
                prefix[0]=0;
                suffix[0]=sum-nums[0];
                
            }
            else if(i==nums.length-1){
                prefix[i]=sum-nums[i];
                suffix[i]=0;
            }
            else{
                prefix[i]=prefix[i-1]+nums[i-1];
                suffix[i]=sum-prefix[i]-nums[i];
                
            }
              
        }
       
         System.out.println(Arrays.toString(prefix));
         System.out.println(Arrays.toString(suffix));
        int curr=0;
        
        for(int i=0;i<nums.length;i++){
            long pref=prefix[removeQueries[i]];
            long suf=suffix[removeQueries[i]];
            if(i==0){
                ans[i]=Math.max(pref,suf);
            }
            else{
                for(int j=0;j<i;j++){
                    if(removeQueries[j]<removeQueries[i]){
                        pref-=nums[removeQueries[j]];
                        
}
                    else{
                        suf-=nums[removeQueries[j]];
                        
                    }
                    
                }
                ans[i]=Math.max(pref,suf);
            }
           
}
        return ans;
        
    }
}