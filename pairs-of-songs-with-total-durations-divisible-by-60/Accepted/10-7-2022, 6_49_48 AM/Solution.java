// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60

class Solution {
   public int numPairsDivisibleBy60(int[] time) {
      
        
        HashMap<Integer, Integer> rem2Count = new HashMap<>();
        
        int count = 0;
        
        for(int i : time) {
            int x = i % 60;
            int y = 0;
          
            
            if(x != 0) {
                y = 60 - x;
            }
            if(rem2Count.containsKey(y)) {
                count += rem2Count.get(y);
            }
            rem2Count.put(x, rem2Count.getOrDefault(x, 0) + 1);
        }
        
        return count;
    }
}