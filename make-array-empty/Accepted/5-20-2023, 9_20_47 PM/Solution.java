// https://leetcode.com/problems/make-array-empty

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        Arrays.sort(nums);
        long ans=0;
        int n=nums.length;
        for(int i=1;i<nums.length;i++){
            if(hm.get(nums[i]) <hm.get(nums[i-1])){
                ans+=n-i;
            }
        }
        return ans+n;
    }
}