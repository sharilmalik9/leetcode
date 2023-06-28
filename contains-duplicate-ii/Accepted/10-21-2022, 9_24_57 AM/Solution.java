// https://leetcode.com/problems/contains-duplicate-ii

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> hm= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                List<Integer> ls= hm.get(nums[i]);
                for(int j: ls){
                    if(i-j<=k){
                        return true;
                    }
                }
                hm.get(nums[i]).add(i);
            }
            else{
                List<Integer> ls= new ArrayList<>();
                ls.add(i);
                hm.put(nums[i],ls);
            }
        }
        return false;
    }
}