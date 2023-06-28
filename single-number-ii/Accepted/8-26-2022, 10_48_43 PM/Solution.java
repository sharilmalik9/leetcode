// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i: nums)
        {
            if(hm.containsKey(i))
                hm.put(i,hm.get(i)+1);
            else
                hm.put(i,1);
        }
        for(int i:nums)
        {
            if(hm.get(i)==1)
                return i;
        }
        return 0;
        
    }
}