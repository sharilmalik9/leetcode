// https://leetcode.com/problems/longest-square-streak-in-an-array

class Solution {
    public int longestSquareStreak(int[] nums) {
	 HashMap<Double, Integer> map = new HashMap<Double, Integer>();
	 for(int a:nums)
		 map.put((double) a, 1);
	 
	  Arrays.sort(nums);
	  int max = 0;
	  for(int i = 0;i<nums.length;i++)
	  {
		  double sqrt = Math.sqrt(nums[i]);
		  if(map.containsKey(sqrt))
		  {
			  map.put((double) nums[i], map.get(sqrt)+1);
		  }
	  }
	 // System.out.println("map -->>"+map);
	  for(int a:map.values())
		  max = Math.max(a, max);
	  if(max==1)
		  return -1;
	  return max;
	  
      
  }
}