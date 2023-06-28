// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    HashSet<Integer> hs= new HashSet<>();
        int sum=0;
        for(int i:nums){
            sum+=i;
            if(sum%k==0 && sum!=0){
                return true;
            }
            else if(hs.contains(sum%k)){
                return true;
            }
            else{
                hs.add(sum%k);
            }
        }
        
        return false;
    }
}