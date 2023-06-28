// https://leetcode.com/problems/subarrays-with-k-different-integers

// utmost k length -utmost k-1 length = k length 
// for utmost k length - max till k (i and j )=j-i+1 ie no of elements here 
// if greater than k move the pointer 
class Solution {
    static int subarraysWithAtMostKDistinct(int nums[],int k){
        int ans = 0;
        int l = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0) + 1);
            for(;mp.size() > k;){
                mp.put(nums[l],mp.get(nums[l]) - 1);
                if(mp.get(nums[l]) == 0) mp.remove(nums[l]);
                l++;
            }
            ans += i - l + 1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums,k) - subarraysWithAtMostKDistinct(nums,k - 1);
    }
}