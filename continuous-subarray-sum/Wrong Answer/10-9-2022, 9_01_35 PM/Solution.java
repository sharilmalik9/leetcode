// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    HashSet<Integer> hs= new HashSet<>();
        int sum=0;
        if(k==1 && nums.length>0){
            return true;
        }
        int prev=nums[0]%k;
        for(int i:nums){
            prev=sum;
            sum+=i;
            
            if(sum==1 && k!=1){
                continue;
            }
            if(sum%k==0 && sum!=0){
                return true;
            }
            else if(hs.contains(sum%k)&& sum%k!=prev){
                return true;
            }
            else{
                hs.add(sum%k);
            }
        }
        
        return false;
    }
}