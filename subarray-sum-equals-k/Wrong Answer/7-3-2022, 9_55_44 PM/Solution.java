// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    // for number>1
    public int subarraySum(int[] nums, int k) {
        
       HashMap<Integer,Integer> hp= new HashMap<>();
        hp.put(0,1);
        int sum=0;
        int ans=0;
        
        for(int i:nums){
            sum+=i;
            int rem= sum-k;
            if(hp.containsKey(rem)){
                ans++;
                
            }
            hp.put(sum,hp.getOrDefault(sum,0)+1);
            
        }
        if(sum==k && nums.length>1){
            ans++;
        }
        return ans;
    }
}