// https://leetcode.com/problems/find-all-duplicates-in-an-array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
		 HashMap<Integer,Integer> map=new HashMap<>();
		 if(nums.length==1){
			 return al;
		 }
		 for(int i=0;i<nums.length;i++) {
			 map.put(nums[i],map.getOrDefault(nums[i],0)+1);
		 }
		 for(int i:map.keySet()) {
			 if(map.get(i)>1) {
				 al.add(i);
			 }
		 }
		 Collections.sort(al);
		 return al;
		 
    }
}