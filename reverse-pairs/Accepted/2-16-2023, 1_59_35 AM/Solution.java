// https://leetcode.com/problems/reverse-pairs

class Solution {
    public int reversePairs(int[] nums) {
        
        List<Long> clone = new ArrayList<>();
        
        for(int n: nums) clone.add(Long.valueOf(n));
        
        Collections.sort(clone);
        int n = nums.length;
        int count = 0;
        
        for(int i=n-1;i>=0;i--){
            int index = bs(clone,2*Long.valueOf(nums[i]));
            int indexRemove = bs(clone,Long.valueOf(nums[i]));
			
            if(index<=(indexRemove-1)) count += ((n-1)-index); //In case of negative numbers if index of 2*nums[i] is less than undex of nums[i]
			else count += (n-index);
            clone.remove(indexRemove-1);
            n--;
        }
        
        return count;
        
    }
    //Binary search
    public int bs(List<Long> nums, Long target){
        int l =0;
        int h = nums.size();
        
        while(l<h){
            int m = l + (h-l)/2;
            if(nums.get(m)<=target){
                l = m+1;
            }else{
                h= m;
            }
        }
        
        return l;
    }
}