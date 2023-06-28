// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
          Map<Integer,Integer> sh= new HashMap<>();
        if(nums.length==0){
            return 0;
        }
       

        for(int i=0;i<nums.length;i++) {
            if (!sh.containsKey(nums[i])) {
                sh.put(nums[i], 1);

            }
        }
        int max=1;
        int curr=1;
        for(int i:nums){
            if(!sh.containsKey(i-1)) {
                int that = i;
                if (sh.containsKey(i + 1)) {
                    System.out.println("here");
                    while (sh.containsKey(that + 1)) {
                        that++;
                        curr++;

                    }
                    if (curr > max) {
                        max = curr;
                    }
                    curr=1;

                }
            }

        }
       return max;

       
        
        
    }
}