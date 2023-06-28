// https://leetcode.com/problems/collecting-chocolates

class Solution {
    public long minCost(int[] nums, int x) {
        int n=nums.length;
        long[] cost=new long[nums.length];
        int[] ops=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int min=nums[i];
            int shifts=1;
            int op=0;
            int idx=(i+1)%n;
            while(idx!=i){
                if(nums[idx]+x*shifts<min){
                    op=shifts;
                    min=nums[idx]+x*shifts;
                }
                idx=(idx+1)%n;
                shifts++;
                
            }
            cost[i]=min;
            ops[i]=op;
        }
        int ans=0;
        int curr=0;
         // System.out.println(Arrays.toString(cost));
         // System.out.println(Arrays.toString(ops));
        for(int i=0;i<n;i++){
            System.out.println(curr);
            ans+=cost[i];
            if(curr>ops[i]){
                ans=ans-ops[i]*x;
                
            }
            else if(curr<ops[i] ){
                if(curr==0){
                    curr=ops[i];
                    continue;
                }
                ans=ans-(ops[i]-curr)*x;
                curr=ops[i];
                
            }
            
        }
        return ans;
        
    }
}