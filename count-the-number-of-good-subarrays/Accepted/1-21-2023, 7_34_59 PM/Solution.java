// https://leetcode.com/problems/count-the-number-of-good-subarrays

class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        int i=0;
        int j=0;
        long ans=0;
        for( i=0;i<nums.length;i++){
            while(j<nums.length && k>0 ){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            k-=(hm.get(nums[j])-1);
            j++;
            }
            if(k>0){
                break;
            }
            ans+=nums.length-j+1;
            hm.put(nums[i],hm.get(nums[i])-1);
            k+=hm.get(nums[i]);
        }
            return ans;
    }
}