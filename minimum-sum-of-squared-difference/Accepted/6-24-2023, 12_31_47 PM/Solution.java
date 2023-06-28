// https://leetcode.com/problems/minimum-sum-of-squared-difference

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<nums1.length;i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        while(k1+k2 >0){
            int largest = map.lastKey();
            if(largest == 0) break;
            int toRemove = Math.min(k1+k2, map.get(largest));
            map.put(largest-1,map.getOrDefault(largest-1,0)+toRemove);
            k1 -= toRemove;
            map.put(largest,map.get(largest)-toRemove);
            if(map.get(largest) == 0) map.remove(largest);
        }
        long result = 0;
        for(int key: map.keySet()){
            result += 1L*map.get(key)*key*key;
        }
        return result;
    }
}